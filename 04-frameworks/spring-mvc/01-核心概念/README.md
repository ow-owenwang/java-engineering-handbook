# 01-核心概念

## Spring MVC 架构图

Spring MVC 是基于 **Front Controller (前端控制器)** 设计模式构建的。

1. **DispatcherServlet**: 核心入口，负责分发请求。
2. **HandlerMapping**: 根据 URL 找到对应的处理器 (Controller)。
3. **HandlerAdapter**: 负责调用处理器。
4. **ViewResolver**: 将逻辑视图名解析为物理视图（如 JSP, Thymeleaf）。

## 配置方式

### 1. Java Config (推荐)

```java
@Configuration
@EnableWebMvc
@ComponentScan("com.example")
public class WebConfig implements WebMvcConfigurer {
    // 自定义配置
}
```

### 2. 初始化器 (Replacement for web.xml)

```java
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { return null; }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
```
