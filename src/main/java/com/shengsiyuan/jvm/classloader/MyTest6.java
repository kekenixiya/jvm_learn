package com.shengsiyuan.jvm.classloader;


public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter:" + Singleton.counter);
        System.out.println("counter1:" + Singleton.counter1);
    }
}

class Singleton {
    public static int counter = 1;
    public static Singleton instance = new Singleton();
    private Singleton() {
        counter++;
        counter1++; //准备阶段的意义，
        System.out.println("构造方法里:" + counter1);
    }
    public static int counter1 = 5;

    public static Singleton getInstance() {
        System.out.println("getInstance:" + counter1);return instance;
    }
}
