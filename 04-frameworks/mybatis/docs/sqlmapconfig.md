## 配置项顺序
配置项的顺序：

1. properties（属性）
2. settings（全局配置参数）
3. typeAliases（类型别名）
4. typeHandlers（类型处理器）
5. objectFactory（对象工厂）
6. plugins（插件）
7. environments（环境集合属性对象）
8. environment（环境子属性对象）
9. transactionManager（事务管理）
10. dataSource（数据源）
11. mappers（映射器）

## <properties>
数据库配置信息可以单独提取出来，创建 `db.properties`：

```plain
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8
jdbc.username=root
jdbc.password=123
```

在 `SqlMapConfig.xml` 引入：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--加载外部配置文件-->
    <properties resource="db.properties">
        <!--会覆盖外部配置文件 db.properties 中的同名属性-->
        <property name="jdbc.username" value="root"/>
        <property name="jdbc.password" value="123456"/>
    </properties>
    <!-- 和 spring 整合后 environments 配置将废除 -->
    <environments default="development">
        <environment id="development">
            <!-- 使用 jdbc 事务管理 -->
            <transactionManager type="JDBC"/>
            <!-- 数据库连接池 -->
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url"
                          value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="UserMapper.xml"/>
    </mappers>
</configuration>

```

`<font style="color:#F5222D;"><property name="jdbc.password" value="123456"/></font>`<font style="color:#F5222D;"> 没有覆盖 </font>`<font style="color:#F5222D;">db.properties</font>`<font style="color:#F5222D;"> 中的同名属性。</font>



## <typeAliases>
在编写 `mapper.xml` 时，需要指定 `parameterType` 和 `resultType` 的值，因为值是全路径类名，编写不方便，为了提高开发效率，可以指定别名。



MyBatis 默认支持一些别名，详情参考官网。



下面对 `User` 进行别名配置：

```xml
<typeAliases>
  <typeAlias type="org.example.User" alias="user"/>
  <!--批量定义别名，扫描整个包下的类，别名为类名，大小写不敏感（常用）-->
  <package name="org.example.pojo"/>
</typeAliases>
```

别名定义之后就可以在 `mapper.xml` 中使用了。



## <mappers>
mapper 常见配置方法：

```xml
<mappers>
  <mapper resource="UserMapper.xml"/>
  <mapper class="org.example.UserMapper"/>
  <package name="org.example.mappers"/>
</mappers>
```

