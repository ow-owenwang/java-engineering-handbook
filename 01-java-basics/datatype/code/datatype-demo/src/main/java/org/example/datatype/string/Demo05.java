package org.example.datatype.string;

import java.util.Date;

public class Demo05 {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(String.format("%te", date));//一个月的某一天（0-31） -> 22
        System.out.println(String.format("%tb", date));//月份简称 -> 4月
        System.out.println(String.format("%tB", date));//月份全称 -> 四月
        System.out.println(String.format("%tA", date));//星期全称 -> 星期三
        System.out.println(String.format("%ta", date));//星期简称 -> 周三
        System.out.println(String.format("%tc", date));//全部日期和时间信息 -> 周三 4月 22 17:46:57 GMT+08:00 2020
        System.out.println(String.format("%tY", date));//四位年份 -> 2020
        System.out.println(String.format("%tj", date));//一年中的第几天 -> 113
        System.out.println(String.format("%tm", date));//月份 -> 04
        System.out.println(String.format("%td", date));//一个月中的第几天 -> 22
        System.out.println(String.format("%ty", date));//两位年份 -> 20

        System.out.println("======================");

        System.out.println(String.format("%tH", date));//2位数的24时制的小时（00-23） -> 22
        System.out.println(String.format("%tI", date));//2位数的12时制的小时（01-12） -> 10
        System.out.println(String.format("%tk", date));//2位数的24时制的小时（0-23） -> 22
        System.out.println(String.format("%tl", date));//2位数的12时制的小时（1-12） -> 10
        System.out.println(String.format("%tM", date));//2位数的分钟（00-59） -> 48
        System.out.println(String.format("%tS", date));//2位数的秒数（00-60） -> 15
        System.out.println(String.format("%tL", date));//3位数毫秒数（000-999） -> 735
        System.out.println(String.format("%tN", date));//9位数的微秒数（000000000-999999999） -> 735000000
        System.out.println(String.format("%tp", date));//上午或下午标记 -> 下午
        System.out.println(String.format("%tz", date));//相对于GMT RFC 82 格式的数字时区偏移量 -> +0800
        System.out.println(String.format("%tZ", date));//时区缩写形式的字符串 -> GMT+08:00
        System.out.println(String.format("%ts", date));//1970-01-01 00:00:00 至今经过的秒数 -> 1587566895
        System.out.println(String.format("%tQ", date));//1970-01-01 00:00:00 至今经过的毫秒数 -> 1587566895735

        System.out.println("======================");

        System.out.println(String.format("%tF", date));//年-月-日 格式 -> 2020-04-22
        System.out.println(String.format("%tD", date));//月/日/年 格式 -> 04/22/20
        System.out.println(String.format("%tc", date));//全部日期和时间信息 -> 周三 4月 22 22:57:04 GMT+08:00 2020
        System.out.println(String.format("%tr", date));//时:分:秒 PM(AM) 格式 -> 10:57:04 下午
        System.out.println(String.format("%tT", date));//时:分:秒 格式 -> 22:57:04
        System.out.println(String.format("%tR", date));//时:分 格式 -> 22:57

        System.out.println("======================");

        /*
            常规类型的格式化
                %b、%B ： 结果被格式化为布尔类型 -> true
                %h、%H ： 结果被格式化为散列码 -> A05A5198
                %s、%S ： 结果被格式化为字符串类型 -> "abc"
                %c、%C ： 结果被格式化为字符类型 -> 'a'
                %d ： 结果被格式化为十进制整数 -> 50
                %o ： 结果被格式化为八进制整数 -> 11
                %x、%X ： 结果被格式化为十六进制整数 -> 4b1
                %e ： 结果被格式化为用计算机科学计数法表示的十进制数 -> 1.700000e+01
                %a ： 结果被格式化为带有效位数和指数的十六进制浮点值 -> 0X1.C000000000001P4
                %n ： 结果为特定平台的行分隔符 ->
                %% ： 结果为字面量 % -> %
         */

        System.out.println(String.format("%b", 3 > 5));//false
        System.out.println(String.format("%d", 400 / 2));//200
        System.out.println(String.format("%x", 200));//c8
    }
}
