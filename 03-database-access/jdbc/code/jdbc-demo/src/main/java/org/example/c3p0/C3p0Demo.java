package org.example.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0 使用方法演示
 */
public class C3p0Demo {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //使用指定名称的配置
        //ComboPooledDataSource ds = new ComboPooledDataSource("otherc3p0");

        //因为配置文件中最大连接数为10，所以获取第11个连接会获取失败
        for (int i = 1; i <= 11; i++) {
            //获取连接对象
            Connection conn = ds.getConnection();
            System.out.println(i + ": " + conn);

            if (i == 5) {
                //归还连接到连接池中，因为归还了一个，所以第11个可以获取到
                conn.close();
            }
        }

    }
}
