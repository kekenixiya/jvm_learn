package com.shengsiyuan.jvm.bytecode;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-10-11
 **/
public class MyTest2 {
    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public MyTest2() {
    }

    public MyTest2(int i) {
        System.out.println("aaaa");
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);

        in = 20;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str){
        synchronized (str){
            System.out.println("hello world");
        }
    }

    private synchronized static void test2(){

    }

    static {
        System.out.println("test");
    }
}
