package com.in28minutes.microservices.currencyexhangeservice.controllers;

import com.in28minutes.microservices.currencyexhangeservice.exceptions.CommonException;
import com.in28minutes.microservices.currencyexhangeservice.models.ExchangeValue;
import com.in28minutes.microservices.currencyexhangeservice.repositories.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment env;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> exhangeValue(@PathVariable final String from, @PathVariable final String to) {

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to)
                .orElseThrow(() -> new CommonException("Exchange value not found!", HttpStatus.NOT_FOUND));
        exchangeValue.setServerPort(Integer.parseInt(env.getProperty("local.server.port")));
        logger.info("{}", exchangeValue);
        return ResponseEntity.ok(exchangeValue);
    }
}