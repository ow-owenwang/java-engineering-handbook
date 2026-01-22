package org.example.common.Calendar;

import java.util.Calendar;

public class Demo03 {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(Calendar.DATE);//TODO: ????
        System.out.println(Calendar.YEAR);//TODO: ????

        System.out.println(Calendar.DAY_OF_MONTH);

        System.out.println(instance.getCalendarType());
    }
}
