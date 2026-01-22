```java
public class JDBCDemo {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取数据库链接
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "123456");
            //定义 sql 语句 ? 表示占位符
            String sql = "select * from user where username = ?";
            //获取预处理 statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为 sql 语句中参数的序号（从 1 开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "王五");
            //向数据库发出 sql 执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + resultSet.getString(" username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
```

以上代码未经封装，使用 JDBC 原始方法实现了查询数据库表记录 。





+ 数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，如果使用数据库链接池可解决此问题。
+ SQL 语句在代码中硬编码，造成代码不易维护，实际应用 SQL 变化的可能较大，SQL 变动需要改变 java 代码。 
+ 使用 preparedStatement 向占有位符号传参数存在硬编码，因为 SQL 语句的 where 条件不一定，可能多也可能少，修改 SQL 还要修改代码，系统不易维护。 
+ 对结果集解析存在硬编码（查询列名），SQL 变化导致解析代码变化，系统不易维护，如果能将数据库记 录封装成 POJO 对象解析比较方便。  





