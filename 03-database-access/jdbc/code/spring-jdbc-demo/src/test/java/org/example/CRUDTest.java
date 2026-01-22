package org.example;

import org.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CRUDTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 查询总条数
     */
    @Test
    public void test1(){
        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Long.class);
        System.out.println(count);
    }

    /**
     * 查询一条
     */
    @Test
    public void test2(){
        User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE username=?", new BeanPropertyRowMapper<>(User.class), "Bill");
        System.out.println(user);
    }

    /**
     * 查询所有
     */
    @Test
    public void test3(){
        List<User> users = jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }

    /**
     * 更新
     */
    @Test
    public void test4(){
        int i = jdbcTemplate.update("UPDATE user SET age=? WHERE username=?", 100, "Bill");
        System.out.println(i);
    }

    /**
     * 删除
     */
    @Test
    public void test5(){
        int i = jdbcTemplate.update("DELETE FROM user WHERE username=?", "Bill");
        System.out.println(i);
    }

    /**
     * 插入
     */
    @Test
    public void test6(){
        int i = jdbcTemplate.update("INSERT INTO user (username, age) VALUES(?,?)", "Bill", "10");
        System.out.println(i);
    }
}
