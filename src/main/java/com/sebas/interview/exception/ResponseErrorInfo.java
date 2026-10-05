package com.sebas.interview.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ResponseErrorInfo {

    private String message;
    private LocalDateTime timestamp;
    private HttpStatus status;
    
    public ResponseErrorInfo(String message, LocalDateTime timestamp, HttpStatus status) {
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    

    

    
    
}
