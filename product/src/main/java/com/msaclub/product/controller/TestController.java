package com.msaclub.product.controller;

import com.msaclub.product.common.uitl.ConfigUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final ConfigUtil configUtil;
    @GetMapping("/config")
    public String getConfig() {
        log.info("spring.datasource.url : {}", configUtil.getProperty("spring.datasource.url"));
        return configUtil.getProperty("spring.datasource.url");
    }
}
