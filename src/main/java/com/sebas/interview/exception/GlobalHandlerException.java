package com.sebas.interview.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice 
public class GlobalHandlerException {

    @ExceptionHandler (NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseErrorInfo handleException(NoResourceFoundException ex){
        return createHttpErrorInfo(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseErrorInfo handleHttpClientErrorException(HttpClientErrorException ex){
        return createHttpErrorInfo(ex, HttpStatus.NOT_FOUND);
    }

    private ResponseErrorInfo createHttpErrorInfo(Exception ex, HttpStatus status) {
        return new ResponseErrorInfo(ex.getMessage(), LocalDateTime.now(), status);
    }
    
}
