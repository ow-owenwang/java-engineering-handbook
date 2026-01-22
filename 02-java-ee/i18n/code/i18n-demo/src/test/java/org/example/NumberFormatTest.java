package org.example;

import org.junit.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * NumberFormat 是格式化数字到数字字符串，或货币字符串的工具类
 */
public class NumberFormatTest {
    @Test
    public void test1() {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
        String str = numberInstance.format(123456789.123d);
        System.out.println(str);//123,456,789.123
    }

    @Test
    public void test2() {
        NumberFormat numberInstance = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String str = numberInstance.format(123456789.123d);
        System.out.println(str);//￥123,456,789.12
    }

    @Test
    public void test3() throws ParseException {
        NumberFormat numberInstance = NumberFormat.getCurrencyInstance(Locale.CHINA);
        Double d = (Double) numberInstance.parse("￥123,456,789.12");
        System.out.println(d);//1.2345678912E8

    }
}
