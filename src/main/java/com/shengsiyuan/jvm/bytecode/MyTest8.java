package com.shengsiyuan.jvm.bytecode;

/**
 *  现代JVM 在执行Java代码的时候，通常都会将解释执行和编译执行两者结合起来进行
 *
 *  所谓解释执行，就是通过解释器来读取字节码，遇到相应的指令就去执行该指令
 *
 *  所谓编译执行，就是通过即时编译器（Just In time ,JIT) 将字节码转换为本地机器吗来
 *  执行；现代JVM会根据热点代码来生成相应的本地机器码。
 *
 *  基于栈的指令集与基于寄存器的指令集之间的关系；
 *  1. JVM 执行指令时所采取的的方式是基于栈的指令集
 *  2. 基于栈的指令集主要的操作有入栈和出栈两种
 *  3. 基于栈的指令集的优势在于它可以再不同的平台之间移植，而基于寄存器的指令集
 *  是与硬件架构紧密关联的，无法做到可移植
 *  4. 基于栈的指令集的缺点在于完成相同的操作，指令集数量通常要比基于寄存器的指令集多
 *  ；基于栈的指令集是在内存中完成操作的，而基于寄存器的指令集是直接由CPU来执行的，
 *  它是在高速缓存区中进行的，速度要快得多。虽然虚拟机可以采用一些优化手段，但总体来说
 *  ，基于栈的指令集的执行速度要慢一些。
 *
 */
public class MyTest8 {

    public int myCalculate(){
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        int result = (a + b - c) * d;

        return result;
    }
}