# 03-视图解析与响应

## 1. 视图解析器 (ViewResolver)

在传统 Web 页面应用中，`ViewResolver` 决定如何根据 Controller 返回的逻辑视图名定位到物理文件。

```java
@Bean
public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
}
```

## 2. 响应数据

### `@ResponseBody`
将返回值自动转换为 JSON 或 XML 并写入响应体。底层使用 `HttpMessageConverter`。

### `ResponseEntity<T>`
更强大的控制方式，可以自定义状态码和 Header。

```java
@GetMapping("/download")
public ResponseEntity<byte[]> download() {
    byte[] data = ...;
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=test.txt");
    return new ResponseEntity<>(data, headers, HttpStatus.OK);
}
```

## 3. 静态资源处理

```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**")
            .addResourceLocations("/public/", "classpath:/static/");
}
```
