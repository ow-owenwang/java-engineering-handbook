package org.example.JdbcTemplate;

import org.example.domain.User;
import org.example.utils.PooledJDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo1 {
    private JdbcTemplate template = new JdbcTemplate(PooledJDBCUtils.getDataSource());

    /**
     * 修改 id 为1的用户密码为 !QAZXSW
     */
    @Test
    public void method01() {
        String sql = "update user set password=? where id=?";
        int count = template.update(sql, "!QAZXSW@", 1);
        System.out.println(count);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void method02() {
        String sql = "insert into user values(null, ?, ?)";
        int count = template.update(sql, "B", "1");
        System.out.println(count);
    }

    /**
     * 删除一条记录
     */
    @Test
    public void method03() {
        String sql = "delete from user where id=?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }

    /**
     * 查询，结果集封装到 Map 中
     */
    @Test
    public void method04() {
        String sql = "select * from user where id=?";
        Map<String, Object> map = template.queryForMap(sql, 2);
        System.out.println(map);
    }

    /**
     * 查询，结果集封装到 List 中
     */
    @Test
    public void method05() {
        String sql = "select * from user";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);
    }

    /**
     * 查询所有记录，将其封装为 User 对象的 List 集合
     */
    @Test
    public void method06(){
        String sql = "select * from user";
        List<User> list = template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                return user;
            }
        });

        System.out.println(list);
    }

    /**
     * 查询所有记录，将其封装为 User 对象的 List 集合
     */
    @Test
    public void method07(){
        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(list);
    }


    /**
     * 查询总记录数
     */
    @Test
    public void method08(){
        String sql = "select count(*) from user";
        Long count = template.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
