package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String username;
    private static String password;

    //使用静态代码块，只需读取一次
    static {
        try {
            //创建 Properties 集合类
            Properties pro = new Properties();
            //使用类加载器加载 src 路径下配置文件
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            //1.
            //URL res = classLoader.getResource("jdbc.properties");
            //String path = res.getPath();
            //加载文件
            //pro.load(new FileReader(path));

            //2.
            InputStream in = classLoader.getResourceAsStream("jdbc.properties");
            pro.load(in);
            //获取数据，赋值
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            String driver = pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 释放资源，数据库操作对象、数据库连接
     *
     * @param stmt
     * @param conn
     */
    public static void release(Statement stmt, Connection conn) {
        release(null, stmt, conn);
    }


    /**
     * 释放资源，关闭结果集、数据库操作对象、数据库连接
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}