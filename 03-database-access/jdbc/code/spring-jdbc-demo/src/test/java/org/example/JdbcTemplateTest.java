package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.example.pojo.User;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void test1() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybatis_db");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        List<User> users = jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }
}
