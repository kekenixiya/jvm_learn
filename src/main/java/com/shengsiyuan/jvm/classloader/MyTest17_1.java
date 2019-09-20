package com.shengsiyuan.jvm.classloader;


/**
 * 关于命名空间的重要说明
 * 1.子加载器所加载的类能够访问到父加载器所加载的类
 * 2.父加载器所加载的类无法访问到子加载器所加载的类
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        loader1.setPath("C:\\Users\\qyk\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("class:" + clazz.hashCode());

        Object object = clazz.newInstance();
    }
}
