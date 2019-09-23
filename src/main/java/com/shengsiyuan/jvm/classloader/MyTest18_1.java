package com.shengsiyuan.jvm.classloader;

public class MyTest18_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath( "D:\\learn_pro\\test\\target\\classes\\");

        Class<?> clazz = loader1.loadClass("test2.AA");
        System.out.println(clazz.hashCode());
        System.out.println(clazz.getClassLoader());
    }
}
