package com.shengsiyuan.jvm.bytecode;


/**
 *   栈帧 （stack frame )
 *   栈帧是一种帮助虚拟机执行方法调用和方法执行的数据结构 。
 *
 *   栈帧 是归属线程，不存在并发或同步。
 *
 *   栈帧是一种数据结构， 封装了方法的局部变量表，动态链接信息，方法的返回地址以及操作数栈等信息。
 *
 *   符号引用  直接引用
 *
 *   符号引用: 目标类全局完全的名字 包括类名和包名。
 *
 *   有些符号引用是在类加载阶段或是第一次使用时就会转换为直接引用，这种转换叫做静态解析；另外一些符号引用是在每次运行时转换为直接引用。
 *   这种转换叫做动态链接，这体现java的多态性。
 *
 *     invokevirtual  调用sleep 编码，但是执行是会去检查当前对象的类型
 *
 *    Animal a = new Cat();
 *      a.sleep();
 *      a = new Dog();
 *      a.sleep();
 *      a = new Tiger();
 *      a.sleep();
 *    如上这个例子运行时 a 指向不同的实例。在程序的字节码中a.sleep();都是调用的 Animal 的sleep;
 *
 *
 *
 */

/**
 *   1. invokeinterface ： 调用捷库中的方法，实际上是运行删除决定的，决定调到底调用实现该的那个对象的特定方法
 *   2. invokestatic : 调用静态方法。
 *   3. invokespecial ： 调用自己的私有方法，构造方法(<init>) 以及父类的方法
 *   4. invokevirtual: 调用虚方法 ，运行期动态查找过程
 *   5. invokedvnamic： 动态调用方法。
 *
 */

/**
 *   静态方法的4种情形:
 *
 *   1. 静态方法
 *   2. 父类方法
 *   3. 构造方法
 *   3. 私有方法（是无法被重写的）
 *
 *    以上4中方法称之为非虚方法，我们在类加载阶段就可以将符号引用转换为直接引用的。
 *
 *
 */

public class MyTest4 {
    public static void test() {
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }
}
