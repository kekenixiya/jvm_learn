package com.shengsiyuan.jvm.classloader;

public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("class:" + clazz.hashCode());

       // Object object = clazz.newInstance();
    }
}
