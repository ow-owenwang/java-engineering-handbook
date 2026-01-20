# 04-异常处理

## 核心方式

### 1. `@ControllerAdvice` + `@ExceptionHandler` (全局处理)

这是最推荐的方式，可以将异常处理逻辑从业务代码中解耦。

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(UserNotFoundException ex) {
        ErrorResponse error = new ErrorResponse("NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        ErrorResponse error = new ErrorResponse("INTERNAL_ERROR", "服务器开小差了");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

### 2. `@ResponseStatus`

直接在自定义异常类上使用。

```java
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "无权访问")
public class AccessDeniedException extends RuntimeException {
}
```
