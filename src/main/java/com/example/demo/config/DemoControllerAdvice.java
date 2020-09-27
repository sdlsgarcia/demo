package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class DemoControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(DemoControllerAdvice.class);

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<?> handleSqlException(SQLException ex){
        log.error("Error while doing transaction", ex);
        return new ResponseEntity<>("Error while doing transaction", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
