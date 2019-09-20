package com.shengsiyuan.jvm.classloader;

public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("class:" + clazz.hashCode());

        //如果注释掉改行 并不会实例化MySample MySample 构造方法不会被调用。也不会实例化 MyCat
//        Object object = clazz.newInstance();
    }
}
