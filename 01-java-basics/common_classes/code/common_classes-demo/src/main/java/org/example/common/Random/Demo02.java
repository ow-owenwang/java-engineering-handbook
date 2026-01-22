package org.example.common.Random;

import java.util.Random;
import java.util.Scanner;

/*
 * 用代码模拟猜数字的小游戏。
 *
 *
 * */
public class Demo02 {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = r.nextInt(100) + 1;//[1,100]
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入你猜测的数字：");
            int guessNum = sc.nextInt();//键盘输入猜测的数字

            if (guessNum > randomNum) {
                System.out.println("太大了，请重试。");
            } else if (guessNum < randomNum) {
                System.out.println("太小了，请重试。");
            } else {
                System.out.println("恭喜你，猜中啦！");
                break;//如果猜中，不再重试
            }
        }

        System.out.println("游戏结束。");
    }
}
