package com.lottoland.challenge.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.lottoland.challenge.exception.GameNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({GameNotFoundException.class})
    public ResponseEntity<Map<String, Object>> handleNotFoundException(RuntimeException e, HttpServletRequest request) {
        
    	Map<String, Object> body = new HashMap<>();

    	body.put("timestamp", LocalDateTime.now());
    	body.put("status", HttpStatus.NOT_FOUND);
        body.put("error", e.getMessage());        
        body.put("URI", request.getRequestURI());
        
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);    	
    }

}
