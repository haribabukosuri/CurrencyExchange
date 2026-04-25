package com.currency.exchange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    //@ExceptionHandler(value = "RuntimeException.class")
    @ExceptionHandler(value = {ExchangeRateNotFoundException.class})
    public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.toString());
    }

}
