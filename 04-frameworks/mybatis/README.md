
# MyBatis 知识点总结

## 1. 简介

MyBatis 是一个优秀的基于 Java 的持久层框架，它内部封装了 JDBC，使开发者只需要关注 SQL 语句本身，而不需要花费精力去处理加载驱动、创建连接、创建 statement 等繁杂的过程。

MyBatis 通过 XML 或注解的方式将要执行的各种 statement 配置起来，并通过 Java 对象和 statement 中 SQL 的动态参数进行映射生成最终执行的 SQL 语句，最后由 MyBatis 框架执行 SQL 并将结果映射为 Java 对象并返回。

采用 ORM 思想解决了实体和数据库映射的问题，对 JDBC 进行了封装，屏蔽了 JDBC API 底层访问细节，使我们不用与 JDBC API 打交道，就可以完成对数据库的持久化操作。  



作为持久层的框架，还有一个封装程度更高的框架就是 Hibernate，但这个框架因为各种原因目前在国内的 流行程度下降太多，现在公司开发也越来越少使用。目前使用 Spring Data 来实现数据持久化也是一种趋势。

  



JDBC 存在的问题：

+ 数据库连接创建、释放频繁，造成系统资源浪费，从而影响系统性能，如果使用数据库连接池可解决此问题。
+ SQL语句写在代码中造成代码不易维护，实际应用 SQL 变化的可能较大，SQL 变动需要重新编译。
+ 向 SQL 语句传参数麻烦，因为 SQL 语句的 where 条件不一定，参数可能多也可能少，占位符需要和参数一一对应。如果参数需要改变，都得重新调整顺序。
+ 对结果集解析麻烦，SQL 变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成 POJO 对象解析比较方便。



MyBatis 可以解决以上问题：

+ 在 SqlMapConfig.xml 中配置数据连接池，使用连接池管理数据库链接。
+ 将 SQL 语句配置在 XXXXmapper.xml 文件中与 java 代码分离。
+ MyBatis 自动将 java 对象映射至 SQL 语句，通过 statement 中的 parameterType 定义输入参数的类型。
+ MyBatis 自动将 SQL 执行结果映射至 java 对象，通过 statement 中的 resultType 定义输出结果的类型。



MyBatis 是一个优秀的持久层框架，它对 jdbc 的操作数据库的过程进行封装，使开发者只需要关注 SQL 本身，而不需要花费精力去处理例如注册驱动、创建 connection、创建 statement、手动设置参数、结果集检索等 jdbc 繁杂的过程代码。



MyBatis 通过 xml 或注解的方式将要执行的各种 statement（statement、preparedStatement、CallableStatement）配置起来，并通过 java 对象和 statement 中的SQL 进行映射生成最终执行的 SQL 语句，最后由 MyBatis 框架执行 SQL 并将结果映射成 java 对象并返回。



SqlMapConfig.xml，此文件作为mybatis的全局配置文件，配置了mybatis的运行环境等信息。mapper.xml文件即sql映射文件，文件中配置了操作数据库的sql语句。此文件需要在SqlMapConfig.xml中加载。

2、通过mybatis环境等配置信息构造SqlSessionFactory即会话工厂

3、由会话工厂创建sqlSession即会话，操作数据库需要通过sqlSession进行。

4、mybatis底层自定义了Executor执行器接口操作数据库，Executor接口有两个实现，一个是基本执行器、一个是缓存执行器。

5、Mapped Statement也是mybatis一个底层封装对象，它包装了mybatis配置信息及sql映射信息等。mapper.xml文件中一个sql对应一个Mapped Statement对象，sql的id即是Mapped statement的id。

6、Mapped Statement对sql执行输入参数进行定义，包括HashMap、基本类型、pojo，Executor通过Mapped Statement在执行sql前将输入的java对象映射至sql中，输入参数映射就是jdbc编程中对preparedStatement设置参数。

7、Mapped Statement对sql执行输出结果进行定义，包括HashMap、基本类型、pojo，Executor通过Mapped Statement在执行sql后将输出结果映射至java对象中，输出结果映射过程相当于jdbc编程中对结果的解析处理过程。





Mybatis和hibernate不同，它不完全是一个ORM框架，因为MyBatis需要程序员自己编写Sql语句。mybatis可以通过XML或注解方式灵活配置要运行的sql语句，并将java对象和sql语句映射生成最终执行的sql，最后将sql执行的结果再映射生成java对象。

Mybatis学习门槛低，简单易学，程序员直接编写原生态sql，可严格控制sql执行性能，灵活度高，非常适合对关系数据模型要求不高的软件开发，例如互联网软件、企业运营类软件等，因为这类软件需求变化频繁，一但需求变化要求成果输出迅速。但是灵活的前提是mybatis无法做到数据库无关性，如果需要实现支持多种数据库的软件则需要自定义多套sql映射文件，工作量大。



Hibernate对象/关系映射能力强，数据库无关性好，对于关系模型要求高的软件（例如需求固定的定制化软件）如果用hibernate开发可以节省很多代码，提高效率。但是Hibernate的学习门槛高，要精通门槛更高，而且怎么设计O/R映射，在性能和对象模型之间如何权衡，以及怎样用好Hibernate需要具有很强的经验和能力才行。

总之，按照用户的需求在有限的资源环境下只要能做出维护性、扩展性良好的软件架构都是好架构，框架只有适合才是最好。

