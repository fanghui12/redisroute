package com.chanjet.http;


import com.alibaba.fastjson.JSONObject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.InetSocketAddress;

public class HTTPServer {

    private  static final Logger logger = LoggerFactory.getLogger("RedisRouteService");
    //启动服务，监听来自客户端的请求
    public static void httpserverService() throws IOException {
        HttpServerProvider provider = HttpServerProvider.provider();
        HttpServer httpserver =provider.createHttpServer(new InetSocketAddress(6666), 100);//监听端口6666,能同时接 受100个请求
        httpserver.createContext("/myApp", new MyHttpHandler());
        httpserver.setExecutor(null);
        httpserver.start();
        logger.info("server started");
    }
    //Http请求处理类
    static class MyHttpHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {
            InputStream in = httpExchange.getRequestBody(); //获得输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String temp = null;
            while((temp = reader.readLine()) != null) {
                logger.info("client request:"+temp);
            }

            //相应消息===========================================================
            //JSONObject jsStr = JSONObject.parseObject(temp);

            JSONObject jsStr = new JSONObject();
            jsStr.put("resp_code","000000");
            jsStr.put("resp_desc","SUCCESS");
            String responseMsg = jsStr.toString();   //响应信息
            logger.info("http应答：" + responseMsg);

            httpExchange.sendResponseHeaders(200, responseMsg.length()); //设置响应头属性及响应信息的长度
            OutputStream out = httpExchange.getResponseBody();  //获得输出流
            out.write(responseMsg.getBytes());
            out.flush();
            httpExchange.close();
        }
    }
}
