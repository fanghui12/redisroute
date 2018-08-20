package com.chanjet.redisHttpRoute;

import com.chanjet.constants.Constants;
import com.chanjet.mapper.HttpRespData;
import com.chanjet.mapper.MsgObject;
import com.chanjet.util.EncryptUtil;
import com.chanjet.util.SignUtil;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;


import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class RedishttpRoute {
    private static final  Logger Logger = LoggerFactory.getLogger("RedisRouteService");
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public void redispop(){

        // 接口URL
        String url = Constants.getServerUrl() + "/myApp";
        // 接入用户密钥
        String key = Constants.getKey();

        String ReqJson = null;
        Jedis jedis = new Jedis(Constants.REDIS_IP,Constants.REDIS_PORT);
        jedis.connect();
        while(true){
            List result = jedis.blpop(Constants.TIME_OUT,"hello");
            if(result.isEmpty()) {
                Logger.info("ROUTE获取数据超时.....");
            }else{
                ReqJson = result.get(1).toString();
                Logger.info("ROUTE获取数据" + ReqJson);
                MsgObject msgObject = com.alibaba.fastjson.JSON.parseObject(ReqJson, MsgObject.class);
                String cardNoText = msgObject.getData().getCard_no();
                String mobNoText = msgObject.getData().getMobl_no();
                String transTime = msgObject.getData().getTrans_time();
                String transCode = msgObject.getData().getTrans_code();
                //敏感数据3ds加密================================================
                String cardNo = null;
                String mobNo = null;
                try {
                    cardNo = EncryptUtil.desEncrypt(cardNoText, key);
                    mobNo = EncryptUtil.desEncrypt(mobNoText, key);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                msgObject.getData().setCard_no(cardNo);
                msgObject.getData().setMobl_no(mobNo);

                // 构建签名参数
                TreeMap<String, Object> signParams = new TreeMap<String, Object>();
                signParams.put("trTime", transTime);
                signParams.put("trCode", transCode);
                String sign = SignUtil.signByMap(key, signParams);
                msgObject.getData().setSign(sign);

                //访问httpserver================================================================
                String jsonReq = com.alibaba.fastjson.JSON.toJSONString(msgObject);
                Logger.info("jsonReq: " + jsonReq);
                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(JSON, jsonReq);
                Request request = new Request.Builder().url(url).post(body).build();
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String jsonRsp = null;
                try {
                    jsonRsp = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Logger.info("jsonRsp: " + jsonRsp);

                if (response.isSuccessful()) {

                    HttpRespData res = com.alibaba.fastjson.JSON.parseObject(jsonRsp, HttpRespData.class);

                    Logger.info("HTTP Server响应内容：" + res.toString());

                    if(res.getResp_code().equals("000000")){
                        msgObject.getData().setResp_code("00");
                        msgObject.getData().setResp_desc(res.getResp_desc());
                    }else {
                        msgObject.getData().setResp_code("96");
                        msgObject.getData().setResp_desc(res.getResp_desc());
                    }
                } else {
                    Logger.info("响应码: " + response.code());
                    msgObject.getData().setResp_code(String.valueOf(response.code()));
                    msgObject.getData().setResp_desc(response.message());
                    try {
                        throw new IOException("Unexpected code " + response.message());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


               //向redis应答消息=================================================
                String respstr = com.alibaba.fastjson.JSON.toJSONString(msgObject);
                Logger.info("向redis应答消息："+ respstr);
                jedis.lpush("RESP_KEY", respstr);
            }
        }
    }

}
