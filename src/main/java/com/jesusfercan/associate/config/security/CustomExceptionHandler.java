package com.jesusfercan.associate.config.security;


import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Map<String,String>> exceptionHandler(Exception exception, HttpServletRequest request){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put("message",exception.getLocalizedMessage());
        errorDetails.put("timestamp", LocalDateTime.now().toString());
        errorDetails.put("url",request.getRequestURL().toString());
        errorDetails.put("http-method",request.getMethod());

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if(exception instanceof AccessDeniedException)
            status = HttpStatus.FORBIDDEN;

        return ResponseEntity.status(status).body(errorDetails);
    }
}
