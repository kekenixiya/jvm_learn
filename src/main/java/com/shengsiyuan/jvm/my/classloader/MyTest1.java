package com.shengsiyuan.jvm.my.classloader;

/**
 * @description: 通过子类引用父类的静态字段，不会导致子类初始化,子类也不会被加载
 *
 * @author: zhangchunxing
 * @create: 2018-11-27
 **/
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(SuperClass.value);
    }
}

class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }

}