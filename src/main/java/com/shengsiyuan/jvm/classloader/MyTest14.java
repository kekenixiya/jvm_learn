package com.shengsiyuan.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 如何通过一个给定的字节码路径来去把它相应的资源的信息打印出来。
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        String resourceName = "com/shengsiyuan/jvm/classloader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement());
        }

        System.out.println("---------------");

        Class<?> clazz = String.class;
        System.out.println(clazz.getClassLoader());

        Class<?> MyTest14 = MyTest14.class;
        System.out.println(MyTest14.getClassLoader());

    }
}
