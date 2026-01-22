package org.example.jdbc;

import java.util.ResourceBundle;

public class ResourceBundleDemo {
    public static void main(String[] args) {
        //java.util.ResourceBundle 类可以用来读取项目中类路径下扩展名为 properties 的配置文件。
        //getBundle() 方法接收配置文件的名称。
        //如果是 maven 工程可以把配置文件放到 resources 目录中
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String username = bundle.getString("username");
        String password = bundle.getString("password");

        System.out.println(driver + "\n" + url + "\n" + username + "\n" + password + "\n");

    }
}
