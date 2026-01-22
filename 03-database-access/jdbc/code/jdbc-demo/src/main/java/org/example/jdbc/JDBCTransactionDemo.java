package org.example.jdbc;

import org.example.utils.JDBCUtils;

import java.sql.*;

/**
 * JDBC 事务管理
 *
 */
public class JDBCTransactionDemo {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";

            connection = JDBCUtils.getConnection();
            //开启事务
            connection.setAutoCommit(false);

            ps1 = connection.prepareStatement(sql1);
            ps2 = connection.prepareStatement(sql2);

            ps1.setDouble(1, 500);
            ps1.setInt(2, 1);
            ps2.setDouble(1, 500);
            ps2.setInt(2, 2);

            ps1.executeUpdate();

            //手动制造异常
            int i = 3 / 0;

            ps2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            //事务回滚
            try {
                if (connection != null) {
                    connection.commit();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            JDBCUtils.release(ps1, connection);
            JDBCUtils.release(ps2, null);
        }
    }
}
