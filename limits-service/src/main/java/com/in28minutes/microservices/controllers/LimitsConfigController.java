package com.in28minutes.microservices.controllers;

import com.in28minutes.microservices.config.ConfigProperties;
import com.in28minutes.microservices.models.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigController {

    @Autowired
    private ConfigProperties configs;

    @GetMapping("/limits")
    public ResponseEntity<LimitsConfiguration> retrieveConfigs() {
        return ResponseEntity.ok(new LimitsConfiguration(configs.getMinimum(), configs.getMaximum()));
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public ResponseEntity<LimitsConfiguration> faultToleranceExample() {
        throw new RuntimeException("Not available");
    }

    public ResponseEntity<LimitsConfiguration> fallbackMethod() {
        return ResponseEntity.ok(new LimitsConfiguration(20, 200));
    }

}
