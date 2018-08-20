package com.chanjet.tasks;

import com.chanjet.redis.RedisPush;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TasksPush implements Runnable {
    private  static final Logger logger = LoggerFactory.getLogger(TasksRoute.class);

    @Override
    public void run() {
        RedisPush push = new RedisPush();
        push.redispush();
    }
}
