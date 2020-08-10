package com.in28minutes.microservices.currencyexhangeservice.beans;

import lombok.Data;

@Data
public class Message {
    private String text;
    private String error;

    public Message(String text) {
        this.text = text;
    }
}
