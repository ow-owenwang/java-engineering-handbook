package org.example.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDemo {
    public static void main(String[] args) throws SQLException {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/jdbc_test");
        ds.setUsername("root");
        ds.setPassword("123456");

//        ds.setMaxActive(20);
        ds.setMaxTotal(20);//新版本里setMaxActive是不是改成这个了？
        ds.setMaxIdle(3);
        ds.setMaxWaitMillis(1000);


        for (int i = 0; i < 4; i++) {
            Connection connection = ds.getConnection();
            System.out.println(connection);
        }
    }
}
