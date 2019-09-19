package com.shengsiyuan.jvm.classloader;

public class MyTest15 {
    public static void main(String[] args) {
        int[] strings = new int[3];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("--------------");

        MyTest15[] String = new MyTest15[3];
        System.out.println(String.getClass().getClassLoader());
    }
}
