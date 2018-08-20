package com.chanjet.redis;

import com.alibaba.fastjson.JSONObject;
import com.chanjet.constants.Constants;
import com.chanjet.redisHttpRoute.RedishttpRoute;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisPush {
    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger("RedisRouteService");

    public void redispush()  {
        // 构建请求参数
        JSONObject jsonObj = new JSONObject();
        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("trans_code","020000");
        jsonObj2.put("trans_time","11:12:11");
        jsonObj2.put("card_no","62235437983000023453");
        jsonObj2.put("mobl_no","18701123969");
        jsonObj.put("svrid","PPP_1.8");
        jsonObj.put("key","98888888888");
        jsonObj.put("data",jsonObj2);
        String ReqJson = jsonObj.toJSONString();
    //    String ReqJson = "{'svrid':'PPP_1.8','key':'20180909','data':{'trans_date':'20180901','trans_code':'00001'}}";
        Jedis jedis = new Jedis(Constants.REDIS_IP,Constants.REDIS_PORT);
        jedis.connect();

        while(true) {

            jedis.lpush("hello", ReqJson);
            Logger.info("redis push 数据" + ReqJson);

            //获取应答数据====================================
            List result = jedis.blpop(Constants.TIME_OUT, "RESP_KEY");
            if (result.isEmpty()) {
                Logger.info("tasks1---redis获取数据超时.....");
            } else {
                String RepJson = result.get(1).toString();
                Logger.info("redis pop 数据" + RepJson);
            }

            try
            {
                Thread.currentThread().sleep(5000);//毫秒
            }
            catch(Exception e){}

        }
    }
}
