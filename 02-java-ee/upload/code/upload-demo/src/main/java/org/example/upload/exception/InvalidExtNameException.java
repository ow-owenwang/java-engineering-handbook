package org.example.upload.exception;

/*
* 非法扩展名异常类
* */
public class InvalidExtNameException extends RuntimeException {
    public InvalidExtNameException(String message) {
        super(message);
    }
}
