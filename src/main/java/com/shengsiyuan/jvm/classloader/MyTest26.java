package com.shengsiyuan.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载的一般上下文加载器（获取-使用-还原）
 *
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * try {
 *     //将你想要使用的类加载器放进去
 *     Thread.currentThread().setContextClassLoader(targetTccl);
 *     myMethod();
 * } finally {
 *      Thread.currentThread().setContextClassLoader(classLoader);
 * }
 *
 * myMethod里面则调用了Thread.currentThread().getContextClassLoader(),
 * 获取上下文类加载器做某些事情。
 *
 * 如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖类之前没有被加载过的话）
 *
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制。
 *
 * 当高层提供了统一的接口让底层去实现时，同时又要在高层加载（或实例化）低层的类时候，就必须要通过线程上下文类加载器
 * 来帮助高层的class找到并加载该类。
 */
public class MyTest26 {
    public static void main(String[] args) {
//        Thread.currentThread().setContextClassLoader(MyTest16.class.getClassLoader().getParent());

        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);

        Iterator<Driver> iterable = serviceLoader.iterator();
        // for (Driver driver : serviceLoader) {
        //
        // }

        while (iterable.hasNext()) {
            Driver driver = iterable.next();

            System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器：" + Thread.currentThread().getContextClassLoader());

        System.out.println("ServiceLoader的类加载器：" + serviceLoader.getClass().getClassLoader());
    }
}
