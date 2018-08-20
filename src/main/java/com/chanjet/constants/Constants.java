package com.chanjet.constants;

public class Constants {
    public static final Integer ROWNUM = 1;
    public static final String REDIS_IP = "localhost";
    public static final Integer REDIS_PORT = 6379;
    public static final Integer TIME_OUT = 3;
    public static final Integer ROUTE_MAX_THREAD = 1;
    public static final Integer PUSH_MAX_THREAD = 1;
    public static final String DEVELOP_MODE = "0";
    public static final String CLIENT_NO = "4003";
    public static final String TEST_SERVER_URL = "http://localhost:6666";
    public static final String TEST_KEY = "0123456789ABCDEFFEDCBA9876543210";
    public static final String ONLINE_SERVER_URL = "http://localhost:6666";
    public static final String ONLINE_KEY = "0123456789ABCDEFFEDCBA9876543210";

    public static String getServerUrl() {
        // 生产模式
        if ("1".equals(DEVELOP_MODE)) {
            System.out.println("生产模式");
            return ONLINE_SERVER_URL;
        }
        // 开发模式
        else {
            System.out.println("开发模式");
            return TEST_SERVER_URL;
        }
    }


    public static String getKey() {
        // 生产模式
        if ("1".equals(DEVELOP_MODE)) {
            return ONLINE_KEY;
        }
        // 开发模式
        else {
            return TEST_KEY;
        }
    }

}
