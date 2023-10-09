package com.santander_spring_boot_dio.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String>handlerBusinessException(IllegalArgumentException businessException){
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
        public ResponseEntity<String>handlerNotFoundException(NoSuchElementException notFoundException){
        return new ResponseEntity<>("Resource ID not found ", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String>handlerUnexpectedError(Throwable unexpectedError){
        var msg="Unexpected Server error see the log";
        logger.error(msg,unexpectedError);
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
}
