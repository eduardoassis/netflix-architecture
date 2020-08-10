package com.in28minutes.microservices.currencyexhangeservice.controllers;

import com.in28minutes.microservices.currencyexhangeservice.beans.Message;
import com.in28minutes.microservices.currencyexhangeservice.exceptions.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(CommonException.class)
    protected ResponseEntity<Message> commonExcetionHandler(CommonException ex) {
        Message message = new Message(ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(message);
    }
}
