# Servlet 知识点总结

## 1. 简介

Servlet 是 Java Web 开发的核心技术，用于处理客户端请求并生成动态响应。Servlet 运行在服务器端，可以接收和响应来自客户端的 HTTP 请求。

## 2. 核心概念

### 2.1 Servlet 生命周期
- `init()`: Servlet 初始化方法，在 Servlet 实例创建时调用一次
- `service()`: 处理请求的核心方法，每次请求都会调用
- `destroy()`: Servlet 销毁方法，在 Servlet 实例被移除时调用一次

### 2.2 HttpServlet
`HttpServlet` 是 `GenericServlet` 的子类，专门用于处理 HTTP 请求，提供了以下方法：
- `doGet()`: 处理 GET 请求
- `doPost()`: 处理 POST 请求
- `doPut()`: 处理 PUT 请求
- `doDelete()`: 处理 DELETE 请求
- `service()`: 根据请求方法自动分发到对应的 doXxx 方法

### 2.3 Servlet 配置
- **注解配置**：使用 `@WebServlet` 注解
- **XML 配置**：在 `web.xml` 中配置

### 2.4 反射在 Servlet 中的应用
使用反射机制可以简化 Servlet 的编写，通过 `method` 参数动态调用不同的方法，避免大量的 if-else 判断。

## 3. 示例代码

为了保持代码结构清晰，示例代码按功能拆分为独立的 Maven 项目：

### 3.1 servlet-basic（基础示例）
**项目位置**: `code/servlet-basic/`

包含 Servlet 的基础功能示例：
- **theory/**: Servlet 基础理论示例
  - `ServletConfigServlet.java`: ServletConfig 的使用
  - `ServletContextServlet.java`: ServletContext 的使用
- **annotation/**: 注解配置示例
  - `Annotation1Servlet.java`: 使用 `@WebServlet` 注解配置
- **param/**: 请求参数处理
  - `ParamServlet.java`: 获取请求参数示例
- **response/**: 响应处理
  - `Demo01Servlet.java`: 响应输出示例
  - `sendRedirectServlet.java`: 重定向示例
- **utils/**: 工具类
  - `VerifyCode.java`: 验证码生成工具
- `VerifyCodeServlet.java`: 验证码 Servlet

### 3.2 servlet-reflection（反射机制应用）
**项目位置**: `code/servlet-reflection/`

展示如何使用反射机制简化 Servlet 编写，避免大量 if-else 判断：
- `ServletBase.java`: 使用反射的基类 Servlet，支持通过 method 参数动态调用方法，支持 forward 和 redirect
- `ServletDemo01.java`: 传统方式（if-else）处理多个方法
- `ServletDemo02.java`: 使用反射简化方法调用
- `ServletDemo03.java`: 继承 ServletBase，展示更简洁的写法

### 3.3 servlet-paging（分页功能）
**项目位置**: `code/servlet-paging/`

完整的分页功能实现，包括 DAO、Service、Servlet 三层架构：
- `PageBean.java`: 分页数据封装类（泛型设计）
- `Customer.java`: 客户实体类
- `CustomerDao.java`: 客户数据访问层
- `CustomerService.java`: 客户业务逻辑层
- `ServletCustomer.java`: 处理分页请求的 Servlet

## 4. 项目结构说明

每个项目都是独立的 Maven Web 项目（packaging: war），可以单独导入 IDE 运行。这种拆分方式的好处：
- **结构清晰**：每个项目专注于一个特定的功能点
- **易于维护**：修改某个功能时不会影响其他项目
- **便于学习**：可以按需查看和学习特定的功能模块

