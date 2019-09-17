package com.shengsiyuan.jvm.classloader;

/**
 * 注意：这里指的是将常量放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何联系了
 * 甚至我可以将MyParent2的class文件删除.
 *
 * 助记符：
 * ldc表示将int,float或是String类型的常量值从常量池中推送至栈顶,
 * bipush表示将单字节(-128~127)的常量值推送至栈顶,
 * sipush表示将一个短整型常量值（-32768~32767）推送至栈顶,
 * iconst_1表示将int类型的数字1推送至栈顶(iconst_m1 ~ iconst_5)
 *
 * iconst_m1表示将int类型的数字-1推送至栈顶
 */

public class MyTest2 {
    public static void main(String[] args) {
        /**
         *
         * public static  String str = "hello world";
         * =========================================
         * MyParent2 static block
         * hello world
         */
//        System.out.println(MyParent2.str);

        /**
         *    常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，本质上，调用类并没有直接引用到定义常量的类，
         *    因此并不会触发定义常量的类的初始化
         *    注意: 这里指的是讲常量存放到了MyTest2的常量池中， 之后MyTest2 与MyParent2 没有任何联系了
         *    甚至我可以将生成的MyParent2的class文件删除再执行MyTest2 类也不会影响结果
         *    public static  final String str = "hello world";
         *    ===================
         *    hello world
         */
        System.out.println(MyParent2.str);
    }
}

/**
 *  反向编译 MyTest2 类
 * javap -c com.shengsiyuan.jvm.classloader.MyTest2
 *
 * Compiled from "MyTest2.java"
 * public class com.shengsiyuan.jvm.classloader.MyTest2 {
 *   public com.shengsiyuan.jvm.classloader.MyTest2();
 *
 *      Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #4                  // String hello world
 *        5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: return
 * }
 */
class MyParent2 {
    public static final String str = "hello world";

//    public static  String str = "hello world";
//    public static final short s = 7;
//    public static final int i = 128;
//    public static final int m = 1;
    static {
        System.out.println("MyParent2 static block");
    }
}

