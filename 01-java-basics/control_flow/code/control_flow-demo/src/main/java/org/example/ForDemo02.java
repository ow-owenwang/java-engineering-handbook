package org.example;

/*
 * 输出所有的水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
 * 例如：153 = 1*1*1 + 3*3*3 + 5*5*5
 * */
public class ForDemo02 {
    public static void main(String[] args) {
        for (int n = 100; n < 1000; n++) {
            int num1 = n / 100;
            int num2 = (n - num1 * 100) / 10;
            int num3 = n % 10;

            if (n == num1 * num1 * num1 + num2 * num2 * num2 + num3 * num3 * num3) {
                System.out.println(n);
            }
        }
    }
}
