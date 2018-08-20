package com.chanjet.tasks;

import com.chanjet.redisHttpRoute.RedishttpRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TasksRoute implements Runnable {
    private  static final Logger logger = LoggerFactory.getLogger(TasksRoute.class);

    @Override
    public void run() {
        RedishttpRoute redisroute = new RedishttpRoute();
        redisroute.redispop();
    }
}
