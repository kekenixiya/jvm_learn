package com.shengsiyuan.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyTest27 {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("jdbc.drivers"));
        // 会初始化com.mysql.jdbc.Driver
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("url", "username", "pwd");
    }
}
