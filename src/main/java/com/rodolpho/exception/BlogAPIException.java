package com.rodolpho.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException {

    private HttpStatus status;

    private String message;

    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public BlogAPIException(String message, Throwable cause, HttpStatus status, String message1) {
        super(message, cause);
        this.status = status;
        this.message = message1;
    }

    public BlogAPIException(Throwable cause, HttpStatus status, String message) {
        super(cause);
        this.status = status;
        this.message = message;
    }

    public BlogAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus status, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
