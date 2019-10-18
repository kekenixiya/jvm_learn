package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2018-12-05
 **/
public class Client {
    public static void main(String[] args) {
//        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject rs = new RealSubject();
//        System.out.println(rs.getClass().getClassLoader());
        InvocationHandler ds = new DynamicSubject(rs);
//        System.out.println(ds.getClass().getClassLoader());

        Class<?> cls = rs.getClass();

        Subject subject = (Subject) Proxy
                .newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
