package org.example;

import org.junit.Test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 */
public class MessageFormatTest {

    @Test
    public void test1() {
        MessageFormat messageFormat = new MessageFormat("{0}, World");
        //MessageFormat mf = new MessageFormat("Date: {0}, Salary: {1}", locale);
        String format = messageFormat.format(new Object[]{"Hello"});
        System.out.println(format);
    }

    @Test
    public void test2() {
        String str = "Date: {0}, Salary: {1}";

        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        String date = dateInstance.format(new Date());

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String salary = currencyInstance.format(12345.12d);

        String format = MessageFormat.format(str, date, salary);
        System.out.println(format);
    }
}
