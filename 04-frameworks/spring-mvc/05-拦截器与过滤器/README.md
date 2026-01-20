# 05-拦截器与过滤器

## 1. 拦截器 (HandlerInterceptor)

Spring MVC 特有的组件，可以访问 Spring 上下文和处理器信息。

### 定义拦截器
```java
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 请求处理前，返回 false 则中断请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // Controller 方法执行后，视图渲染前
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 整个请求完成，通常用于资源清理
    }
}
```

### 注册拦截器
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
```

## 2. 拦截器 (Interceptor) vs 过滤器 (Filter)

| 特性 | Filter (过滤器) | Interceptor (拦截器) |
| :--- | :--- | :--- |
| **规范** | Servlet 规范 | Spring MVC 规范 |
| **容器** | Servlet 容器 | Spring 容器 |
| **生命周期管理** | 不支持 Spring Bean 注入 (早前版本) | 支持 Spring Bean 注入 |
| **执行时机** | 请求进入 Servlet 之前/之后 | DispatcherServlet 处理请求中 (Handler 前后) |
| **作用范围** | 几乎可以过滤所有请求 | 仅能拦截 DispatcherServlet 映射的请求 |
