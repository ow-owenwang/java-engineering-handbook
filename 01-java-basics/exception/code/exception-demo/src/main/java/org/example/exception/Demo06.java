package org.example.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
throws 关键字：给别人处理
作用：
    当方法内部抛出异常对象的时候，那么我们就必须处理这个异常对象
    可以使用 throws 关键字处理异常对象，会把异常对象声明抛出给方法的调用者处理，最终交给 JVM 处理-->中断处理

使用格式：在方法声明时使用
    修饰符 返回值类型 方法名(参数列表) throws AAAExcepiton,BBBExcepiton...{
        throw new AAAExcepiton("产生原因");
        throw new BBBExcepiton("产生原因");
        ...
    }

*/
public class Demo06 {
    //public static void main(String[] args) throws FileNotFoundException, IOException {
    //public static void main(String[] args) throws IOException {

    //如果抛出的多个异常对象有子父类关系，那么直接声明父类异常即可
    public static void main(String[] args) throws Exception {
        readFile("c\\a.tx");
    }

    public static void readFile(String fileName) throws IOException {
        if (!fileName.equals("c:\\a.txt")) {
            throw new FileNotFoundException("传递的文件路径不是 c:\\a.txt");
        }

        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件的后缀名不对");
        }

        System.out.println("路径没有问题,读取文件");
    }
}
