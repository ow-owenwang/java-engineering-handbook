# Spring MVC 知识库

这是一个专业的 Spring MVC 知识库，旨在通过系统化的文档和代码案例，帮助开发者快速回顾和掌握 Spring MVC 的核心特性。

## 知识库目录结构

- **01-核心概念 (Core Concepts)**
    - Servlet 基础与 Spring MVC 架构
    - DispatcherServlet 工作流程
    - 配置方式（XML vs Java Config）
- **02-请求映射与参数绑定 (RequestMapping & Data Binding)**
    - `@RequestMapping` 及其变体
    - `@PathVariable`, `@RequestParam`, `@RequestBody`
    - 类型转换与格式化 (Converter & Formatter)
- **03-视图解析与响应 (View Resolution & Response)**
    - 视图解析器 (ViewResolver)
    - `@ResponseBody` 与 `ResponseEntity`
    - 静态资源处理
- **04-异常处理 (Exception Handling)**
    - `@ExceptionHandler`
    - `@ControllerAdvice`
    - HandlerExceptionResolver
- **05-拦截器与过滤器 (Interceptors & Filters)**
    - HandlerInterceptor 的使用
    - Filter 与 Interceptor 的区别
- **06-数据验证与国际化 (Validation & i18n)**
    - JSR-303/JSR-380 Bean Validation
    - 国际化支持 (LocaleResolver)
- **07-文件上传与下载 (File Upload & Download)**
    - MultipartResolver 配置
- **08-异步请求处理 (Async Request)**
    - `Callable` 与 `DeferredResult`
- **09-RESTful API 最佳实践**
    - HATEOAS
    - 版本控制
    - 响应规范
- **10-测试 (Testing)**
    - MockMvc 使用指南
- **samples-code/**
    - 包含各特性的配套示例代码

## 如何使用此知识库

1. **查阅文档**：进入对应章节的文件夹查看 `README.md`。
2. **运行案例**：进入 `samples-code` 目录，按照说明运行代码。
3. **快速速查**：查看 `99-CheatSheet.md` 进行快速回顾。

---
*Created by Spring MVC Expert*
