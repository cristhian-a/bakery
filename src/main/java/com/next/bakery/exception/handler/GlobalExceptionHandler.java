package com.next.bakery.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        // Log the exception if needed
        ex.printStackTrace();

        String errorMessage = "An unecpected error occured: " + ex.getMessage();
        Map<String, Object> body = new HashMap<>();
        body.put("type", "about:blank");
        body.put("title", "Internal Server Error");
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("detail", errorMessage);
        body.put("instance", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleGlobalException(AccessDeniedException ex, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> body = new HashMap<>();
        body.put("type", "about:blank");
        body.put("title", "Forbidden");
        body.put("status", HttpStatus.FORBIDDEN.value());
        body.put("detail", ex.getMessage());
        body.put("instance", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
    }
}
