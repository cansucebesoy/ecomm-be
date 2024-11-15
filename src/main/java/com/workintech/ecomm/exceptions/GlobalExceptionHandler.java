package com.workintech.ecomm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler
    public ResponseEntity<EcommErrorResponse> handleException(EcommException ecommException){
        EcommErrorResponse response = new EcommErrorResponse(
                ecommException.getMessage(),
                LocalDateTime.now(),
                ecommException.getStatus().value()
        );
        return new ResponseEntity<>(response, ecommException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<EcommErrorResponse> handleException(Exception exception){
        EcommErrorResponse response = new EcommErrorResponse(
                exception.getMessage(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
