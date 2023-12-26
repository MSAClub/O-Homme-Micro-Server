package com.msaclub.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${spring.datasource.url}")
    private String myConfigValue;

    @GetMapping("/config")
    public String getConfig() {
        return myConfigValue;
    }
}
