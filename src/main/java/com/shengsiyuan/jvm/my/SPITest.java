package com.shengsiyuan.jvm.my;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2019-01-26
 **/
public class SPITest {
    public static void main(String[] args) {
        // 这个Driver类就是jdk内置的接口，
        // 我们通过JDK内置的ServiceLoader组件去加载相应接口的实现类
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);

        Iterator<Driver> iterable = serviceLoader.iterator();

        while (iterable.hasNext()) {
            Driver driver = iterable.next();

            System.out.println("加载mysql驱动：" + driver.getClass());
        }
    }
}
