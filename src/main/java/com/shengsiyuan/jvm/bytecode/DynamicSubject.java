package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-12-05
 **/
public class DynamicSubject implements InvocationHandler {
    private Object sub;

    public DynamicSubject(Object sub) {
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method:" + method);
        method.invoke(this.sub, args);
        System.out.println("after method:" + method);
        return null;
    }
}
