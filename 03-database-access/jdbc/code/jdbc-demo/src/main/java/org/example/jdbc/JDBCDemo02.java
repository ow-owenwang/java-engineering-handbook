package org.example.jdbc;

import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * MySQL 预编译功能
 */
public class JDBCDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //数据库信息
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jdbc_test";

        //注册驱动
        Class.forName(driver);
        //获取链接
        Properties properties = new Properties();
        properties.setProperty("user", "root");//注意这里是 user，不是 username
        properties.setProperty("password", "123456");
        Connection connection = DriverManager.getConnection(url, properties);
        Statement statement = connection.createStatement();
        statement.executeUpdate("prepare aaa from 'select * from user where id=?'");
        statement.executeUpdate("set @str='1'");
        ResultSet rs = statement.executeQuery("execute aaa using @str");
        rs.next();
        String id = rs.getString("id");
        String user_username = rs.getString("username");
        String user_password = rs.getString("password");
        System.out.println(id + " " + user_username + " " + user_password);



    }
}
