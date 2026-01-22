package org.example.common.DateTime;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * LocalTime 和 DayOfWeek 示例
 * 
 * Java 8 引入的日期时间 API
 */
public class LocalTimeDemo {
    public static void main(String[] args) {
        // LocalTime: 表示时间（不包含日期）
        LocalTime now = LocalTime.now();
        System.out.println("当前时间: " + now);
        
        // DayOfWeek: 枚举类型，表示一周的某一天
        DayOfWeek sunday = DayOfWeek.SUNDAY;
        System.out.println("星期天: " + sunday);
    }
}
