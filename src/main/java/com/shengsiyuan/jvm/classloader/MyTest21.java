package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

/**
 *  类加载器的双亲委托模型的好处：
 *      1. 可以确保hava核心库的类型安全:
 *      所有的Java应用都至少会引用java.lang.Object 类，也就是说在运行期，java.lang.Object 这个类会被加载到java虚拟机中，
 *      ；如果这个加载过程是由java应用自己的类加载器所完成的，那么很可能会在JVM中存在多个版本
 *      java.lang.object类，而且这些类之间还是不兼容的，相互不可见的(正是命名空间在发挥作用)。
 *      借助于双亲委托机制，java 核心库的加载工作都是有启动类加载器来统一完成，从而确保了java应用所使用的都是一个版本的java
 *      核心类库，他们之间是相互兼容的。
 *
 *      2.可以确保java核心类库所提供的类是不会被自己定义的类所替代
 *
 *      3.不同的类加载器 可以为相同名称(binary name) 的类创建额外的命名空间，相同名称的类可以并存在java 虚拟机中，只是需要
 *      不同的类加载器来加载他们即可。不同的类加载器所加载的类之间是不兼容的。这就相当于在java虚拟机内部又创建了一个又一个
 *      相互隔离的java类空间，这类技术在很多框架都得到了实际应用。
 *
 *
 *
 *
 *
 */
public class MyTest21 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("C:\\Users\\qyk\\Desktop\\");
        loader2.setPath("C:\\Users\\qyk\\Desktop\\");

        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);

        /**
         * Exception in thread "main" java.lang.reflect.InvocationTargetException
         * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
         * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * 	at java.lang.reflect.Method.invoke(Method.java:498)
         * 	at com.shengsiyuan.jvm.classloader.MyTest21.main(MyTest21.java:23)
         * Caused by: java.lang.ClassCastException: com.shengsiyuan.jvm.classloader.MyPerson cannot be cast to com.shengsiyuan.jvm.classloader.MyPerson
         * 	at com.shengsiyuan.jvm.classloader.MyPerson.setMyPerson(MyPerson.java:7)
         * 	... 5 more
         * false
         *
         * object1   object2  是由不同的类加载器加载的类 他们的类命名空间是不可见的
         */
        method.invoke(object1, object2);


    }
}
