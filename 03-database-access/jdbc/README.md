# JDBC 知识点总结

## 1. 简介

JDBC (Java Database Connectivity) 是 Java 提供的用于访问数据库的标准 API。它提供了一套用于执行 SQL 语句的 Java API，使得 Java 程序可以访问各种关系型数据库。

## 2. 核心概念

### 2.1 JDBC 基础
- **DriverManager**: 管理数据库驱动
- **Connection**: 数据库连接
- **Statement/PreparedStatement**: 执行 SQL 语句
- **ResultSet**: 结果集

### 2.2 连接池
- **C3P0**: 开源的 JDBC 连接池
- **DBCP**: Apache 的数据库连接池
- **Druid**: 阿里巴巴的数据库连接池（推荐）

### 2.3 JdbcTemplate
Spring 提供的 JDBC 封装，简化了 JDBC 的使用。

## 3. 示例代码

为了区分底层基础和 Spring 生态的使用方式，示例代码分为两个独立的 Maven 项目：

### 3.1 jdbc-demo（原生 JDBC）
**项目位置**: `code/jdbc-demo/`

包含原生 JDBC 的使用示例：
- **jdbc/**: 原生 JDBC 基础操作
  - `JDBCDemo01.java`: JDBC 基本使用
  - `JDBCDemo02.java`: JDBC 进阶示例
  - `JDBCLoginDemo.java`: 登录功能示例
  - `JDBCTransactionDemo.java`: 事务处理
- **JdbcTemplate/**: JdbcTemplate 基础使用（不依赖 Spring 容器）
  - `JdbcTemplateDemo.java`: JdbcTemplate 简单演示
- **c3p0/**: C3P0 连接池示例
- **dbcp/**: DBCP 连接池示例
- **druid/**: Druid 连接池示例
- **transaction/**: 事务处理示例
- **utils/**: 工具类

**特点**：
- 底层基础，不依赖 Spring 框架
- 适合理解 JDBC 的核心原理

### 3.2 spring-jdbc-demo（Spring JDBC）
**项目位置**: `code/spring-jdbc-demo/`

展示如何在 Spring 生态中使用 JDBC：
- `JdbcTemplateTest.java`: 手动创建 JdbcTemplate 的基础示例
- `CRUDTest.java`: 使用 Spring IoC 容器管理 JdbcTemplate 的完整 CRUD 操作
- `applicationContext.xml`: Spring 配置文件
- `jdbc.properties`: 数据库连接配置
- `User.java`: 用户实体类

**特点**：
- 使用 Spring IoC 容器管理 JdbcTemplate
- 使用 Spring Test 框架进行测试
- 完整的 CRUD 操作示例

## 4. 项目结构说明

每个项目都是独立的 Maven 项目，可以单独导入 IDE 运行。这种拆分方式的好处：
- **清晰区分**：原生 JDBC（底层基础）和 Spring JDBC（Spring 生态）分开
- **易于理解**：可以对比两种使用方式的区别
- **便于学习**：可以按需查看和学习特定的实现方式

## 5. 使用说明

### 5.1 配置数据库
在使用前，需要修改 `jdbc.properties` 文件中的数据库连接信息：
```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/your_database
jdbc.username=your_username
jdbc.password=your_password
```

### 5.2 运行示例
进入对应的项目目录，运行示例代码：
```bash
cd code/jdbc-demo
mvn test
```
