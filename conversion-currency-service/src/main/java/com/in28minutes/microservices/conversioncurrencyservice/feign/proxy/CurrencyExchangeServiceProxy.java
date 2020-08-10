package com.in28minutes.microservices.conversioncurrencyservice.feign.proxy;

import com.in28minutes.microservices.conversioncurrencyservice.models.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "netflix-zuul-api-gateway-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange-service/currency-exchange/{from}/to/{to}")
    ResponseEntity<CurrencyConversionBean> exchangeValue(@PathVariable final String from, @PathVariable final String to);

}
