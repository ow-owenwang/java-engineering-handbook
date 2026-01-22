package org.example;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {
    @Test
    public void test1(){
        Locale locale = new Locale("zh", "CN");
        System.out.println(locale);//zh_CN

        Locale zh = new Locale("zh");
        System.out.println(zh);//zh

        //读取本地默认环境
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);//zh_CN

        //为了简化开发，可以以常量访问
        //使用常量可以避免繁琐的区域编码信息
        Locale china = Locale.CHINA;
        System.out.println(china);//zh_CN
        String displayCountry = china.getDisplayCountry();
        String language = china.getLanguage();
        System.out.println(displayCountry);//中国
        System.out.println(language);//zh

        //修改系统方言
        //Locale.setDefault(Locale.US);
    }
}
