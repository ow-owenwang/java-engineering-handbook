package org.example.common.Scanner;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("输入的 int 数字是：" + num);
        String str = sc.next();
        System.out.println("输入的字符串是：" + str);
    }
}
