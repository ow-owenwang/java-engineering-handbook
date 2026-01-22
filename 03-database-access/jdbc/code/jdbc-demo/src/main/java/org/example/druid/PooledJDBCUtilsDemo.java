package org.example.druid;

import org.example.utils.PooledJDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 加入数据库连接池后的 JDBCUtils 工具类测试
 * <p>
 * user 表中添加一条记录
 */
public class PooledJDBCUtilsDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = PooledJDBCUtils.getConnection();
            ps = conn.prepareStatement("insert into user values(null, ?, ?)");
            ps.setString(1, "A");
            ps.setString(2, "123456");

            int i = ps.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            PooledJDBCUtils.close(ps, conn);
        }
    }
}
