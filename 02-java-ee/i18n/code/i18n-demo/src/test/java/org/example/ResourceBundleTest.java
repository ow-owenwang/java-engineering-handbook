package org.example;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    @Test
    public void test1() {
        ResourceBundle rb = ResourceBundle.getBundle("info");
        String value = rb.getString("msg1");
        System.out.println(value);//如果已经对 .properties 的内容进行了转码就不会出现乱码

        //只有 .properties 编码为 utf8 时才有效
        String val = new String(rb.getString("msg1").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(val);
    }

    @Test
    public void test2() {
        Locale.setDefault(Locale.US);
        ResourceBundle bundle = ResourceBundle.getBundle("info");
        String format = MessageFormat.format(bundle.getString("msg2"), new Object[]{"😄"});
        System.out.println(format);
    }


}
