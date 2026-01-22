package org.example.exception;

/*
* 自定义运行时异常
* */
public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException() {
        super();
    }

    public MyRuntimeException(String message) {
        super(message);
    }
}
