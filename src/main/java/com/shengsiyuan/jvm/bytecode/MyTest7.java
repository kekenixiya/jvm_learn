package com.shengsiyuan.jvm.bytecode;

import java.util.Date;

/**
 * @title: 54_虚方法与动态分析分派机制详解
 *
 *   针对于方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构
 *   ( virtual method table , vtable) ,描述方法调用的入口地址  ,
 *   类加载链接阶段生成-符号引用转换为直接引用
 *
 *
 *   针对于invokeinterface指令来说，虚拟机会建立一个叫做接口方法表的数据结构
 *   （interface method table ,itable)
 *
 *
 *
 *
 * @author: zhangchunxing
 * @create: 2018-11-26
 **/
public class MyTest7 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test("hello");
//        dog.test(new Date());
    }
}

class Animal {
    public void test(String str) {
        System.out.println("animals str");
    }

    public void test(Date date) {
        System.out.println("animal date");
    }
}

class Dog extends Animal {
    @Override
    public void test(String str) {
        System.out.println("dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("dog date");
    }
}