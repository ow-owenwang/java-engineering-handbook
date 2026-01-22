package org.example.exception;

/*
* 自定义编译期异常
* */
public class MyCompileTimeException extends Exception{
    public MyCompileTimeException() {
        super();
    }

    public MyCompileTimeException(String message) {
        super(message);
    }
}
