package org.example;

/*
 * for 循环的执行流程
 * */
public class ForDemo01 {
    public static void main(String[] args) {
        int m = 1;
        for (System.out.println("a"); m < 3; System.out.println("b"), m++) {
            System.out.println("c");
        }
    }
}
