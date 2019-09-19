package com.shengsiyuan.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义类加载器
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public MyTest16(String classLoaderName) {
        super(); // 将系统类加载器当作该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent); // 显示指定该类加载的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent); // 将系统类加载器当作该类加载器的父加载器
    }



    @Override
    public Class<?> findClass(String name) {
        System.out.println("name = [" + name + "]");
        System.out.println("findClass invoked");
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }




    private byte[] loadClassData(String className) {
        // load the class data from the connection
        //FileInputStream is = null;
        byte[] data = null;
        //  ByteArrayOutputStream baos = null;
        className = className.replace(".", "\\");
        try(FileInputStream is =
                    new FileInputStream(new File(this.path + className + this.fileExtension));
            ByteArrayOutputStream baos =
                    new ByteArrayOutputStream()) {
            this.classLoaderName = this.classLoaderName.replace(".", "\\");

            //is = new FileInputStream(new File(name + this.fileExtension));

            //baos = new ByteArrayOutputStream();
            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        loader1.path = "D:\\JVM_PRO\\jvm_learn\\target\\classes\\com\\shengsiyuan\\jvm\\classloader";

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println("-----------------------");

//        loader1 = null;
//        clazz = null;
//        object = null;



        loader1 = new MyTest16("loader2");

        loader1.path = "C:\\Users\\85239\\Desktop\\";

        clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        object = clazz.newInstance();
        System.gc();
        Thread.sleep(100000);
        System.out.println(object);
//
//        MyTest16 loader2 = new MyTest16(loader1, "loader2");
//
//        loader2.path = "C:\\Users\\85239\\Desktop\\";
//
//        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
//        System.out.println("class:" + clazz2.hashCode());
//        Object object2 = clazz2.newInstance();
//        System.out.println(object2);
//
//        System.out.println("-----------------------");
//
//        MyTest16 loader3 = new MyTest16("loader3");
//
//        loader2.path = "C:\\Users\\85239\\Desktop\\";
//
//        Class<?> clazz3 = loader3.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
//        System.out.println("class:" + clazz3.hashCode());
//        Object object3 = clazz3.newInstance();
//        System.out.println(object3);

     //   test(loader1);
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");

        Object object = clazz.newInstance();

        System.out.println(object);

    }

}
