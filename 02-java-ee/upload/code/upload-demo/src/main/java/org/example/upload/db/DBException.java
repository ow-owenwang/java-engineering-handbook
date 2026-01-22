package org.example.upload.db;

public class DBException extends RuntimeException {
    public DBException() {
        // TODO Auto-generated constructor stub
    }

    public DBException(String msg) {
        super(msg);
    }

    public DBException(String msg, Exception ex) {
        super(msg, ex);
    }
}
