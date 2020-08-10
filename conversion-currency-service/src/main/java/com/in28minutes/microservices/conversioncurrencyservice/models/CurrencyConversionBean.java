package com.in28minutes.microservices.conversioncurrencyservice.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConversionBean {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private int serverPort;
}
