package org.example.jdbc;

import java.sql.*;

public class JDBCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //数据库信息
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jdbc_test";
        String username = "root";
        String password = "123456";

        //注册驱动
        Class.forName(driver);
        //获取链接
        Connection connection = DriverManager.getConnection(url, username, password);
        //获取操作数据库的预处理对象
        PreparedStatement ps = connection.prepareStatement("select * from user where username=? or password=?");
        ps.setString(1, "Doe");
        ps.setString(2, "333");
        //执行 SQL，获取结果集
        ResultSet rs = ps.executeQuery();
        loop(rs);

        System.out.println("--------------------");

        ps.setString(1, "Doe");
        ps.setString(2, "111");
        ResultSet rs1 = ps.executeQuery();
        loop(rs1);

    }


    public static void loop(ResultSet rs) throws SQLException {
        if (rs != null) {
            //遍历结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                System.out.println(id + " " + username1 + " " + password1);
            }
        }
    }
}
