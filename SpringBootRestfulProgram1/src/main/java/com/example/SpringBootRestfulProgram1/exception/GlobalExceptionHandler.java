package com.example.SpringBootRestfulProgram1.exception;

import com.example.SpringBootRestfulProgram1.entities.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String>  error = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                error.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        Map<String,Object> response = new HashMap<>();
        response.put("success", "false");
        response.put("message", "Validation failed");
        response.put("error", error);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}
