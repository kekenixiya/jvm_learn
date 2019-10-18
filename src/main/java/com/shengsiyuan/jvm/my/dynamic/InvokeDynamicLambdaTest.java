package com.shengsiyuan.jvm.my.dynamic;

import java.util.function.Consumer;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2019-01-16
 **/
public class InvokeDynamicLambdaTest {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;


    }
}

class TestLambda {
    void display(Consumer consumer) {

    }
}
