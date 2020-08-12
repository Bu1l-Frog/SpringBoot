package com.example.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class AjaxExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    public String defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{

        e.printStackTrace();
        return e.getMessage();
    }
}
