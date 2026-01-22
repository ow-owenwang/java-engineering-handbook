# MyBatis 入门指南

## 1. 引入依赖

引入 jar 包：

```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.24</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis</artifactId>
  <version>3.5.6</version>
</dependency>
```

创建 `log4j.properties`：

```plain
# Global logging configuration
log4j.rootLogger=DEBUG, stdout
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n

```

创建 `SqlMapConfig.xml`：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 和 spring 整合后 environments 配置将废除 -->
    <environments default="development">
        <environment id="development">
            <!-- 使用 jdbc 事务管理 -->
            <transactionManager type="JDBC"/>
            <!-- 数据库连接池 -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url"
                          value="jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
</configuration>

```

创建 user 表：

```sql
CREATE TABLE `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(32) NOT NULL COMMENT '用户名称',
	`birthday` DATE DEFAULT NULL COMMENT '生日',
	`sex` CHAR(1) DEFAULT NULL COMMENT '性别',
	`address` VARCHAR(256) DEFAULT NULL COMMENT '地址',
	PRIMARY KEY (`id`)
);
```

创建 POJO 类：

```java
import java.util.Date;

public class User {
    private int id;
    private String username;// 用户姓名
    private String sex;// 性别
    private Date birthday;// 生日
    private String address;// 地址

    // set/get ...
}
```

创建 SQL 映射文件：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace：命名空间，用于隔离 SQL，还有一个很重要的作用，后面会讲 -->
<mapper namespace="test">
    <!-- id： statement 的 id 或者叫做 SQL 的 id-->
    <!-- parameterType：声明输入参数的类型 -->
    <!-- resultType：声明输出结果的类型，应该填写 pojo 的全路径 -->
    <!-- #{}：输入参数的占位符，相当于 JDBC 的？ -->
    <select id="queryUserById" parameterType="int"
            resultType="org.example.User">
        SELECT *
        FROM `user`
        WHERE id = #{id}
    </select>
</mapper>
```

在 `SqlMapConfig.xml` 文件中加载映射文件：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 和 spring 整合后 environments 配置将废除 -->
    <environments default="development">
        <environment id="development">
            <!-- 使用 jdbc 事务管理 -->
            <transactionManager type="JDBC"/>
            <!-- 数据库连接池 -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url"
                          value="jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>

 		<!-- 加载映射文件 -->
    <mappers>
        <mapper resource="User.xml"/>
    </mappers>
</configuration>

```

编写测试用例：

```java
public class Demo01 {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object u = sqlSession.selectOne("queryUserById", 1);

        System.out.println(u); //User{id=1, username='Doe', sex='1', birthday=null, address='null'}

        sqlSession.close();
    }
}
```

