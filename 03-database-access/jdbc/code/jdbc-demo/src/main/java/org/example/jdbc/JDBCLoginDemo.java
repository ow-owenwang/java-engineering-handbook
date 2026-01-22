package org.example.jdbc;

import org.example.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 通过键盘录入用户名和密码
 * 如果用户名和密码正确，登陆成功
 */
public class JDBCLoginDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String s = scanner.nextLine();
        System.out.println("请输入密码：");
        String s1 = scanner.nextLine();
        boolean login = JDBCLoginDemo.login(s, s1);
        if (login) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 登录功能，存在 SQL 注入问题，如密码输入：a' or '1'='1，总是能登陆成功
     * @param username
     * @param password
     * @return
     */
    public static boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from user where username='" + username + "' and password='" + password + "'");
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }

        return false;
    }


    /**
     * 使用 PreparedStatement 实现，解决 SQL 注入问题
     *
     * @param username
     * @param password
     * @return
     */
    public static boolean login1(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, ps, conn);
        }

        return false;
    }
}
