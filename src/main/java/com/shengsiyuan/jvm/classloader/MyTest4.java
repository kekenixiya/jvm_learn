package com.shengsiyuan.jvm.classloader;

/**
 * 对于数组实例来说，其类型是由JVM运行期间动态生成的，表示为[Lcom.shengsiyuan.jvm.classloader.MyParent4
 * 这种形式。动态生成的类型，其父类型就是Object。
 * 对于数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度之后的类型.
 *
 * anewarray：创建一个引用类型的（如：类，接口、数组）数组，并将其引用值压入栈顶。
 * newarray:表示创建一个指定的原始类型（如：int,float,char等）的数组，并将其引用值压入栈顶。
 */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4[] myParent4 = new MyParent4[1];
//        System.out.println(myParent4.getClass());

//        Class<?> clazz = myParent4.getClass();
//        System.out.println(clazz.getClassLoader());
//        System.out.println(MyParent4.class.getClassLoader());

//        MyParent4[][] myParent41 = new MyParent4[1][1];
//        System.out.println(myParent41.getClass());
//        System.out.println(myParent41.getClass().getSuperclass());
//        System.out.println(myParent4.getClass().getSuperclass());
//        System.out.println("==============");
//
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

//        MyParent4 myParent41 = new MyParent4();

    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }

}