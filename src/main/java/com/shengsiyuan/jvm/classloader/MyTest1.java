package com.shengsiyuan.jvm.classloader;

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化，
 * 当一个类初始化时，要求其父类全部都已经初始化完毕了。
 *
 * -XX:+TraceClassLoading，用于追踪类的加载信息并打印。
 * -XX:+TraceClassUnLoading，用于追踪类的卸载信息并打印。
 */
/**
 *  -XX:+<option>,表示开启选项
 *  -XX:-<option>,表示关闭选项
 *  -XX:<option>=<value>,标识对选项设置值
 */

/**
     * [Loaded com.shengsiyuan.jvm.classloader.MyTest1 from file:/D:/JVM_PRO/jvm_learn/target/classes/]
     * [Loaded sun.launcher.LauncherHelper$FXHelper from D:\Java_JDK\Java\jdk1.8.0_181\jre\lib\rt.jar]
     * [Loaded java.lang.Class$MethodArray from D:\Java_JDK\Java\jdk1.8.0_181\jre\lib\rt.jar]
     * [Loaded java.lang.Void from D:\Java_JDK\Java\jdk1.8.0_181\jre\lib\rt.jar]
     * [Loaded com.shengsiyuan.jvm.classloader.MyParent1 from file:/D:/JVM_PRO/jvm_learn/target/classes/]
     * [Loaded com.shengsiyuan.jvm.classloader.MyChild1 from file:/D:/JVM_PRO/jvm_learn/target/classes/]
     * MyParent1 static block
     * hello world
 */
public class MyTest1 {
    public static void main(String[] args) {
        /**
         *   MyParent1 static block
         *   MyChild1 static block
         *   welcome
         */
//        System.out.println(MyChild1.str2);
        /**
         *  MyParent1 static block
         *  hello world
         */
        System.out.println(MyChild1.str);
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }

}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome";
    static {
        System.out.println("MyChild1 static block");
    }
}
