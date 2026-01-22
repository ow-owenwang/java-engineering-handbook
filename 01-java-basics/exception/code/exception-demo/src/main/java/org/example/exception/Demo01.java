package org.example.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 异常分为编译器异常和运行期异常两种
 *
 * */
public class Demo01 {
    public static void main(String[] args) {

        //编译期异常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            //传一个错误的格式
            date = sdf.parse("1999-0909");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);//null


        //运行期异常
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
