package org.example.login.dao;

import org.example.login.domain.User;
import org.example.login.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * 操作数据库中 user 表的类
 * */
public class UserDao {

    //声明 JDBCTemplate 对象共用
    private JdbcTemplate tpl = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 登陆方法
     *
     * @param user
     * @return
     */
    public User login(User user) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            return tpl.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }

    }
}
