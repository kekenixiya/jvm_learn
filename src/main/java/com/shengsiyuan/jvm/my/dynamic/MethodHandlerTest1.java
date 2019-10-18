package com.shengsiyuan.jvm.my.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @description: ${description}
 * @author: zhangchunxing
 * @create: 2019-01-15
 **/
public class MethodHandlerTest1 {
    public static void main(String[] args) {

        Object rcvr = "a";
        try {
            MethodType mt = MethodType.methodType(int.class); // 方法签名
            MethodHandles.Lookup l = MethodHandles.lookup(); // 调用者，也就是当前类。调用者决定有没有权限能访问到方法
            MethodHandle mh = l.findVirtual(rcvr.getClass(), "hashCode", mt).bindTo(rcvr); //分别是定义方法的类，方法名，签名

            int ret;
            try {
                // ret = (Integer) mh.invokeExact(rcvr); // 代码，第一个参数就是接收者
                System.out.println(mh.invokeExact(rcvr));
            } catch (Throwable t) {
                t.printStackTrace();
            }
        } catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }

    }

}
