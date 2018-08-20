package com.chanjet;

import com.chanjet.constants.Constants;
import com.chanjet.http.HTTPServer;
import com.chanjet.tasks.TasksRoute;
import com.chanjet.tasks.TasksPush;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class Application {
    private static Logger logger = LogManager.getLogger("RedisRouteService");
    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class);

//        //启动http服务
//        HTTPServer httpserver = new HTTPServer();
//        httpserver.httpserverService();
//
//        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(Constants.ROUTE_MAX_THREAD);
//        for (int i = 0; i < Constants.ROUTE_MAX_THREAD; i++){
//            cachedThreadPool.execute(new TasksRoute());
//        }
//        logger.info("Tashpop 线程创建完成。。线程个数:" + Constants.ROUTE_MAX_THREAD);
//        ExecutorService cachedThreadPool1 = Executors.newFixedThreadPool(Constants.PUSH_MAX_THREAD);
//        for (int i = 0; i < Constants.PUSH_MAX_THREAD; i++){
//            cachedThreadPool1.execute(new TasksPush());
//        }
//        logger.info("Tashpush 线程创建完成。。线程个数:" + Constants.PUSH_MAX_THREAD);
    }
}
