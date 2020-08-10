package com.in28minutes.microservices.conversioncurrencyservice.controllers;

import com.in28minutes.microservices.conversioncurrencyservice.feign.proxy.CurrencyExchangeServiceProxy;
import com.in28minutes.microservices.conversioncurrencyservice.models.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class CurrencyConversionController {
    private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping(value = "/convert/{from}/to/{to}/{value}", produces = "application/json")
    public ResponseEntity<CurrencyConversionBean> convertCurrency(@PathVariable final String from, @PathVariable final String to, @PathVariable final BigDecimal value) {
        CurrencyConversionBean currencyConversionBean = currencyExchangeServiceProxy.exchangeValue(from, to).getBody();
        currencyConversionBean.setTotalCalculatedAmount(currencyConversionBean.getConversionFactor().multiply(value).setScale(2, RoundingMode.FLOOR));
        currencyConversionBean.setQuantity(value);
        logger.info("{}", currencyConversionBean);
        return ResponseEntity.ok(currencyConversionBean);
    }

}
