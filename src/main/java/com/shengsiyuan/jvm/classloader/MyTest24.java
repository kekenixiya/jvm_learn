package com.shengsiyuan.jvm.classloader;

/**
 *  当前类加载器（current classloader)
 *  每个类都会使用自己的类加载器 （即加载自身的类加载器) 来加载其他类(
 *  值得是所依赖的类)
 *  如果class X 引用 Class Y , 那么 X 的类加载器也会加载 Y ，前提是Y
 *  还没被加载
 *
 *  线程上下文类加载器 （Context Classloader)
 *
 *  线程的上下文类加载器是从JDK 1.2 开始引入的，类Thread
 *  的 getContextClassLoader() 与 setContextClassLoader(ClassLoader c1 )
 * 分别用来获取和设置上下文类的加载器
 *
 * 如果没有通过 setContextClassLoader(ClassLoader c1 ) 进行设置，线程将继承其父
 * 线程的上下文类加载器。
 *  Java 应用运行的初始线程的上下文类加载器系统类加载器，在线程中运行的代码可以通过该类
 *  加载器来加载类与资源。
 *
 *  线程上下文类的加载器的重要性:
 *  SPI (Service Provider Interface) 服务提供者接口
 *
 *  父ClassLoader 可以使用当前线程Thread
 *   Thread.currentThread().getContextClassLoader() 所指定的ClassLoader 加载的类。
 *   这就改变了父ClassLoader 不能使用子ClassLoader 或是其他没有直接父子关系的
 *   ClassLoader加载类的情况。即改变了双亲委托模型。
 *
 *   线程上下文类加载器就是当前线程 Current ClassLoader
 *
 *   在双亲委托模型下，类加载时由下至上的，即下层的类加载器委托上层进行加载。但是对于SPI 来说
 *   有些接口是JAVA 核心库所提供的，而Java核心库是由启动类加载器来加载的，而这些接口的实现类
 *   是来自于不同的jar包(厂商提供),java启动类加载器是不会加载其他来源的jar包的，
 *   这样传统的双亲委托模型无法满足SPI的要求，而通过给当前线程设置上下文加载器，就可以
 *   有设置的上下文类加载器来实现对于接口实现类的加载。
 *
 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());

    }
}
