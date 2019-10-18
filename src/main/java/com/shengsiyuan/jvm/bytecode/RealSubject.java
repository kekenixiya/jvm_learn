package com.shengsiyuan.jvm.bytecode;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-12-05
 **/
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("from RealSubject");
    }
}
