package com.shengsiyuan.jvm.classloader;

/**
 * 当一个接口初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候（如引用到接口中所定义的常量时），才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {

//        System.out.println(MyChild55.b);

        System.out.println(MyChild5.b);

//        new CC();
//        new CC();

    }
}

//interface MyParent55 {
//    public static int a = 5;
//
//}
//
//interface MyChild55 extends  MyParent55{
//    public static int b = 6;
//}


interface MyParent5 {
    // 接口的字段默认是public static final
    // int a = new Random().nextInt(4);
//    int a = 5;

    Thread thread1 = new Thread() {
        {
            System.out.println("MyParent5初始化了");
        }
    };


}

class MyChild5 extends MyParent implements MyParent5 {

//    class MyChild5  implements MyParent5 {
    // int b = new Random().nextInt(4);

    public static Thread thread2 = new Thread() {
        {
            System.out.println("MyChild5初始化了");
        }
    };

     public static int b = 4;
}

class MyParent {
    static {
        System.out.println("MyParent 初始化");
    }
}

class CC {
    /**
     * 加上 static  只会加载时调用一次 ，new 多个对象时只会看到一次
     */
    static  {
        System.out.println("hello");
    }

    /**
     *    不加上 static  只会加载时调用一次 ，new 多个对象时只会看到打印多次
     */
    {
        System.out.println("hello");
    }

    public CC (){
        System.out.println("C");
    }
}