# Spring MVC 快速速查表 (Cheat Sheet)

## 常用注解

| 注解 | 用途 |
| :--- | :--- |
| `@Controller` | 标记控制层组件 |
| `@RestController` | `@Controller` + `@ResponseBody` |
| `@RequestMapping` | 映射请求路径 |
| `@PathVariable` | 提取 URI 模板变量 |
| `@RequestParam` | 提取查询参数/表单参数 |
| `@RequestBody` | 将 JSON 请求体映射为对象 |
| `@ResponseBody` | 将方法返回值直接作为响应体 |
| `@ModelAttribute` | 绑定请求参数到 Model，或在执行 Controller 前执行 |
| `@ControllerAdvice` | 定义全局控制增强（异常处理、数据绑定） |

## 常用接口

- `WebMvcConfigurer`: 扩展 Java Config 配置。
- `HandlerInterceptor`: 拦截请求（preHandle, postHandle, afterCompletion）。
- `Converter<S, T>`: 自定义类型转换。
- `HandlerExceptionResolver`: 较低级别的异常处理器。

## 常用对象

- `ModelAndView`: 包含视图和模型数据。
- `ResponseEntity<T>`: 包含响应状态码、头信息和响应体。
- `RedirectAttributes`: 专门用于重定向时的参数传递。

## 执行流程简图

`Request` -> `Filter` -> `DispatcherServlet` -> `Interceptor` -> `Controller` -> `Interceptor` -> `ViewResolver` -> `View` -> `Response`
