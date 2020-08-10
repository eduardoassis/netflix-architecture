package com.in28minutes.microservices.currencyexhangeservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "from_value")
    private String from;

    @Column(name = "to_value")
    private String to;

    private BigDecimal conversionFactor;

    @Transient
    private int serverPort;

    public ExchangeValue(String from, String to, BigDecimal conversionFactor) {
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
    }
}