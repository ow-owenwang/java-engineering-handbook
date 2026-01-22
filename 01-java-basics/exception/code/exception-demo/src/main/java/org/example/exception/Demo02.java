package org.example.exception;

/*
 * 异常和错误是不一样的
 * */
public class Demo02 {
    public static void main(String[] args) {


        //内存溢出的错误，创建的数组太大了，超出了给 JVM 分配的内存
        //TODO:没有报错！！！
        int[] array = new int[1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024 * 1024];
        System.out.println(array);
        byte[] b = new byte[1024 * 1024 * 600];

    }
}
