package org.example.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 不通过配置文件的方式
 */
public class C3p0Demo01 {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_test");
        ds.setUser("root");
        ds.setPassword("123456");
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");

        ds.setAcquireIncrement(5);
        ds.setInitialPoolSize(20);
        ds.setMinPoolSize(2);
        ds.setMaxPoolSize(50);

        Connection connection = ds.getConnection();
        System.out.println(connection);
    }
}
