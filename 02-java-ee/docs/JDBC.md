# JDBC

## 基本概念

JDBC，即 Java 数据库连接，英文称为 Java Database Connectivity。它其实是官方定义的一套操作数据库的接口。各个数据库厂商去实现这套接口，提供数据库驱动 jar 包。我们可以使用这套 JDBC 接口编程，但真正执行的代码是驱动 jar 包中的实现类。

![](assets/document_image_rId4.png)

![](assets/document_image_rId4.png)

使用 JDBC 的好处：

如果要开发访问数据库的程序，只需要会调用 JDBC 接口中的方法即可，不用关注类是如何实现的。

使用同一套 Java 代码，进行少量的修改就可以访问其他支持 JDBC 的数据库。

## 快速入门

步骤：

导入驱动 jar 包，复制 mysql-connector-java-8.0.25.jar 到项目的 libs 目录下，然后右键 libs 选择 Add As Library。

注册驱动

获取数据库连接对象 Connection

定义 SQL

获取执行 SQL 语句的对象 Statement

执行 SQL，接受返回结果

处理结果

释放资源

import java.sql.*;public class JDBCTest {    public static void main(String[] args) {        Connection connection = null;        PreparedStatement preparedStatement = null;        ResultSet resultSet = null;        try {            // 加载数据库驱动            Class.forName("com.mysql.jdbc.Driver");            // 通过驱动管理类获取数据库链接            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "root");            // 定义 SQL 语句 ? 表示占位符            String sql = "select * from user where username = ?";            // 获取执行 SQL 的 Statement 对象            preparedStatement = connection.prepareStatement(sql);            // 设置参数，第一个参数为 SQL 语句中参数的序号（从1开始），第二个参数为设置的参数值            preparedStatement.setString(1, "王五");            // 向数据库发出 SQL 执行查询，查询出结果集            resultSet = preparedStatement.executeQuery();            // 遍历结果集            while (resultSet.next()) {                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("username"));            }        } catch (Exception e) {            e.printStackTrace();        } finally {            // 释放资源            if (resultSet != null) {                try {                    resultSet.close();                } catch (SQLException e) {                    e.printStackTrace();                }            }            if (preparedStatement != null) {                try {                    preparedStatement.close();                } catch (SQLException e) {                    e.printStackTrace();                }            }            if (connection != null) {                try {                    connection.close();                } catch (SQLException e) {                    e.printStackTrace();                }            }        }    }}

其中注册驱动，通过查看源代码，在 com.mysql.jdbc.Driver 类中存在静态代码块：

static {    try {        java.sql.DriverManager.registerDriver(new Driver());    } catch (SQLException E) {        throw new RuntimeException("Can't register driver!");    }}

MySQL 5 之后的驱动 jar 包可以省略注册驱动的步骤。

获取数据库连接时，如果连接的是本机 MySQL 服务器，并且 MySQL 服务默认端口是3306，则 url 可以简写为： jdbc:mysql:///数据库名称 。url 后面还可以追加一些参数，如：characterEncoding=utf8 解决乱码问题。

Connection 实例可以通过 createStatement() 或者 prepareStatement() 获取执行 SQL 语句的对象，执行 SQL 之后，返回值可能是结果集或者影响的条数，用影响的条数可以进一步判断是否执行成功。

Statment 代表一条语句对象，用于发送 SQL 语句给服务器，用于执行静态 SQL 语句并返回它所生成结果的对象。

Statment 常用方法：

boolean execute(String sql)：可以执行任意的 SQL。

int executeUpdate(String sql)：执行 DML（insert、update、delete）语句、DDL(create，alter、drop)语句。返回值是影响的行数，可以通过这个影响的行数判断 DML 语句是否执行成功。如果返回值>0，则执行成功，反之，则失败。

ResultSet executeQuery(String sql)：执行 DQL（select）语句。

PreparedStatment 的优点：

prepareStatement() 会先将 SQL 语句发送给数据库预编译。PreparedStatement 会引用着预编译后的结果。可以多次传入不同的参数给 PreparedStatement 对象并执行。减少 SQL 编译次数，提高效率。

安全性更高，没有 SQL 注入的隐患。

提高了程序的可读性

![](assets/document_image_rId4.png)

SQL 注入问题：

在拼接 SQL 时，有一些 SQL 的特殊关键字参与字符串的拼接。会造成安全性问题。

如输入一个用户，然后随便输入密码：

select * from user where username = 'root' and password = 'a' or 'a' = 'a';

解决 SQL 注入只需要使用 PreparedStatement 对象即可，它会预编译 SQL，使用 ? 作为占位符，最后对占位符赋值。

今后尽量使用 PreparedStatement 进行数据库的增删改查操作，它不仅可以有效地防止 SQL 注入，而且执行效率更高。

ResultSet 是结果集对象，封装了查询结果。结果集对象支持很多方法来获取结果集中的数据，并且可以获取到特定数据类型的数据，如：

int getInt(int i)：参数代表列的编号，从1开始。

String getString(String str)：参数为列名。

...

常用的数据类型转换：

![](assets/document_image_rId4.png)

释放资源：

遵循的原则：先开的后关，后开的先关。

事务处理：

事务是一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。

JDBC 中是通过 Connection 实例来管理事务的。管理事务的方法如下：

setAutoCommit(boolean autoCommit) ：开启事务，调用该方法设置参数为 false，即开启事务。需在执行 SQL 之前。

commit()：提交事务，需 SQL 执行完毕后。

rollback()：回滚事务，在 catch 中回滚。

注意：

用 com.mysql.jdbc.Driver 时，可能控制台会报以下错误，这是因为用的 MySQL 数据库版本较新，需要我们使用新的驱动。

Loading class 'com.mysql.jdbc.Driver'. This is deprecated. The new driver class is 'com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

驱动选择正确之后，接下来是时区的设置 url:jdbc:mysql://localhost:3306/mango?serverTimezone=Asia/Shanghai。

## 连接池

数据库连接池是一个存放有若干数据库连接对象的池子（其实就是一个集合），当需要访问数据库时，无需再手动创建连接，直接从容器获取即可。使用连接池的好处是可以有效地缓解频繁创建连接、关闭连接所造成的资源浪费，提高响应速度。

Java 为数据库连接池提供了公共的接口 javax.sql.DataSource，各个数据库厂商提供的连接池必须实现这个接口，这样应用程序可以方便的切换不同厂商的连接池！

需要注意的是，传统通过 JDBC 操作数据库时，con.close() 方法会关闭连接。当使用连接池技术时，此方法会把连接归还给连接池，而不是关闭。

常用数据库连接技术有：

Druid

c3p0

DBCP

### c3p0

导入坐标：

<!-- https://mvnrepository.com/artifact/com.mchange/c3p0 --><dependency>    <groupId>com.mchange</groupId>    <artifactId>c3p0</artifactId>    <version>0.9.5.5</version></dependency>

创建配置文件，在类路径下创建 c3p0.properties 或者 c3p0-config.xml 文件。文件名是固定的不能修改。

<c3p0-config>  <!-- 使用默认的配置读取连接池对象 -->  <default-config>    <!--  连接参数 -->    <property name="driverClass">com.mysql.cj.jdbc.Driver</property>    <property name="jdbcUrl">jdbc:mysql://localhost:3306/ssm</property>    <property name="user">root</property>    <property name="password">123456</property>    <!-- 连接池参数 -->    <property name="initialPoolSize">5</property>    <property name="maxPoolSize">10</property>    <property name="checkoutTimeout">3000</property>  </default-config>  <named-config name="otherc3p0">    <!--  连接参数 -->    <property name="driverClass">com.mysql.cj.jdbc.Driver</property>    <property name="jdbcUrl">jdbc:mysql://localhost:3306/db</property>    <property name="user">root</property>    <property name="password">123456</property>    <!-- 连接池参数 -->    <property name="initialPoolSize">5</property>    <property name="maxPoolSize">8</property>    <property name="checkoutTimeout">1000</property>  </named-config></c3p0-config>

程序默认使用 <default-config> 配置信息，使用无参构造器即可创建一个连接池对象：

ComboPooledDataSource ds = new ComboPooledDataSource();Connection connection = ds.getConnection();

在一些特殊情况下可能需要使用不同的数据源，此时可以把 <named-config name="otherc3p0"> 的 name 值作为参数创建连接池对象：

ComboPooledDataSource ds = new ComboPooledDataSource("otherc3p0");

### Druid

导入坐标：

<!-- https://mvnrepository.com/artifact/com.alibaba/druid --><dependency>    <groupId>com.alibaba</groupId>    <artifactId>druid</artifactId>    <version>1.2.6</version></dependency>

创建配置文件，格式为 .properties，名称任意，存放位置任意，但是需要手动加载

driverClassName=com.mysql.cj.jdbc.Driverurl=jdbc:mysql://127.0.0.1:3306/dbusername=rootpassword=123456initialSize=5maxActive=10maxWait=3000

获取连接：

public static void test() throws Exception {    Connection connection = null;    PreparedStatement stmt = null;    try {        Properties prop = new Properties();        InputStream in = druidDemo.class.getClassLoader().getResourceAsStream("druid-config.properties");        prop.load(in);        DataSource ds = DruidDataSourceFactory.createDataSource(prop);        connection = ds.getConnection();        stmt = connection.prepareStatement("insert into user values(null,?,?,?)");        stmt.setString(1, "123@qq.com");        stmt.setString(2, "222");        stmt.setString(3, "Li");        int i = stmt.executeUpdate();        System.out.println(i);    } catch (Exception e) {        e.printStackTrace();    } finally {        if (stmt != null) {            try {                stmt.close();            } catch (SQLException e) {                e.printStackTrace();            }        }        if (connection != null) {            try {                connection.close();            } catch (SQLException e) {                e.printStackTrace();            }        }    }}

## JDBC 工具类

当数据库操作多了之后，JDBC 原始方式就略显繁琐，下面对其进行封装，抽取出一个工具类 JDBCUtils。该类有以下要求：

包含有获取数据库连接的静态方法

包含有释放资源的静态方法

要保证该类可以正常运行，需要在类路径下配置数据库信息，配置文件名为 jdbc.properties。

public class JDBCUtils {    private static String url;    private static String username;    private static String password;    //使用静态代码块，只需读取一次    static {        try {            //创建 Properties 集合类            Properties pro = new Properties();            //使用类加载器加载 src 路径下配置文件            ClassLoader classLoader = JDBCUtils.class.getClassLoader();            URL res = classLoader.getResource("jdbc.properties");            String path = res.getPath();            //加载文件            pro.load(new FileReader(path));            //获取数据，赋值            url = pro.getProperty("url");            username = pro.getProperty("username");            password = pro.getProperty("password");            String driver = pro.getProperty("driver");            //注册驱动            Class.forName(driver);        } catch (IOException | ClassNotFoundException e) {            e.printStackTrace();        }    }    /**     * 获取连接     *     * @return     * @throws SQLException     */    public static Connection getConnection() throws SQLException {        return DriverManager.getConnection(url, username, password);    }    /**     * 释放资源     *     * @param stmt     * @param conn     */    public static void release(Statement stmt, Connection conn) {        if (stmt != null) {            try {                stmt.close();            } catch (SQLException e) {                e.printStackTrace();            }        }        if (conn != null) {            try {                conn.close();            } catch (SQLException e) {                e.printStackTrace();            }        }    }    /**     * 释放资源     *     * @param rs     * @param stmt     * @param conn     */    public static void release(ResultSet rs, Statement stmt, Connection conn) {        if (rs != null) {            try {                rs.close();            } catch (SQLException e) {                e.printStackTrace();            }        }        if (stmt != null) {            try {                stmt.close();            } catch (SQLException e) {                e.printStackTrace();            }        }        if (conn != null) {            try {                conn.close();            } catch (SQLException e) {                e.printStackTrace();            }        }    }}

获取 properties 配置文件中的配置信息有几种方式，上面的方式略显复杂，下面分别介绍其他方式。

直接以流的方式获取数据，省略手动创建流：

public class JDBCUtils {    private static String url;    private static String username;    private static String password;    private static String driver;    static {        try {            Properties pro = new Properties();            ClassLoader classLoader = JDBCUtils.class.getClassLoader();            InputStream in = classLoader.getResourceAsStream("jdbc.properties");            pro.load(in);            url = pro.getProperty("url");            username = pro.getProperty("username");            password = pro.getProperty("password");            driver = pro.getProperty("driver");            Class.forName(driver);        } catch (IOException | ClassNotFoundException e) {            e.printStackTrace();        }    }        //以下代码省略...}

通过 ResourceBundle 类获取配置文件中的数据：

public class JDBCUtils {    private static String url;    private static String username;    private static String password;    static {        try {            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");            String driver = bundle.getString("driver");            url = bundle.getString("url");            username = bundle.getString("username");            password = bundle.getString("password");            Class.forName(driver);        } catch (ClassNotFoundException e) {            e.printStackTrace();        }    }        //以下代码省略...}

此工具类基于 Druid 连接池的实现：

public class JDBCUtils {    private static DataSource ds;    static {        try {            Properties pro = new Properties();            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid-config.properties"));            ds = DruidDataSourceFactory.createDataSource(pro);        } catch (Exception e) {            e.printStackTrace();        }    }    /**     * 获取连接     */    public static Connection getConnection() throws SQLException {        return ds.getConnection();    }    /**     * 释放资源     */    public static void close(Statement stmt, Connection conn) {        close(null, stmt, conn);    }    public static void close(ResultSet rs, Statement stmt, Connection conn) {        if (rs != null) {            try {                rs.close();            } catch (SQLException e) {                e.printStackTrace();            }        }        if (stmt != null) {            try {                stmt.close();            } catch (SQLException e) {                e.printStackTrace();            }        }        if (conn != null) {            try {                conn.close();//归还连接            } catch (SQLException e) {                e.printStackTrace();            }        }    }    /**     * 获取连接池方法     */    public static DataSource getDataSource() {        return ds;    }}

## Spring JDBC

此外，Spring 框架为了简化 JDBC 开发，也对其进行了一些简单封装。

导入坐标：

<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc --><dependency>    <groupId>org.springframework</groupId>    <artifactId>spring-jdbc</artifactId>    <version>5.3.9</version></dependency>

常用方法：

update()：执行 DML 语句（增、删、改操作）。

queryForMap()：查询结果将结果集封装为 Map 集合，查询的结果集长度只能是1。

queryForList()：查询结果将结果集封装为 List 集合，将每一条记录封装为一个 Map 集合，再将 Map 集合装载到 List 集合中。

query()：查询结果并将结果封装为 JavaBean 对象。参数一般使用 BeanPropertyRowMapper 实现类。

queryForObject()：查询结果，将结果封装为对象。一般用于聚合函数的查询。

基础操作：

public static void test() {    //基于 JDBCUtils 工具类    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());    String sql = "update user set password=? where id=4";    int update = template.update(sql, "999");    System.out.println(update);}

下面进行 CURD 操作。

首先创建实体类 Emp：

public class Emp {	private int id;    private String username;    private String password;    private Double salary;        //setter and getter ...}

public class JdbcTemplateDemo {        //获取 JDBCTemplate 对象    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());    //添加用户    @Test    public void test1() {        String sql = "insert into emp(id, username, password, salary) values(null, ?, ?, ?)";        int i = template.update(sql, "Owen", "123456", 2000);        System.out.println(i);    }    //修改用户工资    @Test    public void test2() {        String sql = "update emp set salary=999 where id=1";        int update = template.update(sql);        System.out.println(update);    }    //删除用户    @Test    public void test3() {        String sql = "delete from emp where id=1";        int i = template.update(sql);        System.out.println(i);    }    //查询 id 为1001的记录，将其封装为 Map 集合。这个方法查询的结果集长度只能是1。    @Test    public void test4() {        String sql = "select * from emp where id=? or id=?";        Map<String, Object> map = template.queryForMap(sql, 1, 2);        System.out.println(map);    }    //查询所有记录，将其封装为 List    @Test    public void test5() {        String sql = "select * from emp";        List<Map<String, Object>> list = template.queryForList(sql);        System.out.println(list);        for (Map<String, Object> map : list) {            System.out.println(map);        }    }    //查询所有记录，将其封装为 Emp 对象的 List 集合    @Test    public void test6() {        String sql = "select * from emp";        List<Emp> list = template.query(sql, new RowMapper<Emp>() {            @Override            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {                Emp emp = new Emp();                int id = resultSet.getInt("id");                String username = resultSet.getString("username");                String password = resultSet.getString("password");                double salary = resultSet.getDouble("salary");                emp.setId(id);                emp.setUsername(username);                emp.setSalary(salary);                emp.setPassword(password);                return emp;            }        });        for (Emp emp : list) {            System.out.println(emp);        }    }    //查询所有记录，将其封装为 Emp 对象的 List 集合    @Test    public void test7() {        String sql = "select * from emp";        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));        for (Emp emp : list) {            System.out.println(emp);        }    }    //查询总记录数    @Test    public void test8() {        String sql = "select count(*) from emp";        Long count = template.queryForObject(sql, Long.class);        System.out.println(count);    }}

update()：执行DML语句。增、删、改语句

queryForMap()：查询结果将结果集封装为 Map 集合，这个方法查询的结果集长度只能是1。

queryForList()：查询结果将结果集封装为 List 集合。

query()：查询结果，将结果封装为 JavaBean 对象。一般使用 BeanPropertyRowMapper 实现类来完成数据到 JavaBean 的自动封装。

queryForObject()：查询结果，将结果封装为对象。一般用于聚合函数的查询。