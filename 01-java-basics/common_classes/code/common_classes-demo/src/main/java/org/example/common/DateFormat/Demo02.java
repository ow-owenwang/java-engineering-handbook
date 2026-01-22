package org.example.common.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 请使用日期时间相关的 API，计算出一个人已经出生了多少天。
 * */
public class Demo02 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的出生日期，格式：yyyy-MM-dd");
        String birthdayDateString = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = sdf.parse(birthdayDateString);
        long birthdayDateTime = birthdayDate.getTime();
        long todayTime = new Date().getTime();
        long time = todayTime - birthdayDateTime;
        if (time < 0) {
            System.out.println("还没出生呢");
        } else {
            System.out.println(time / 1000 / 60 / 60 / 24);
        }
    }
}
