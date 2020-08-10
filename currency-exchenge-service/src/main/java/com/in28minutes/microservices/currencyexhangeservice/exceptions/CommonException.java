package com.in28minutes.microservices.currencyexhangeservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CommonException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

    public CommonException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
