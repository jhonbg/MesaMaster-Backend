package com.laempacadora.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import io.jsonwebtoken.ExpiredJwtException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException ex) {
        boolean isValid = false;
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(createInvalidTokenResponse(isValid));
    }

    private Map<String, Object> createInvalidTokenResponse(boolean isValid) {
        Map<String, Object> response = new HashMap<>();
        response.put("isValid", isValid);
        return response;
    }
}
