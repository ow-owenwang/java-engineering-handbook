package org.example.JdbcTemplate;

import org.example.utils.PooledJDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate 简单演示
 *
 * 把用户 id 为3的密码改为00000
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(PooledJDBCUtils.getDataSource());
        String sql = "update user set password = ? where id = ?";
        int i = jdbcTemplate.update(sql, "00000", 3);
        System.out.println(i);
    }
}
