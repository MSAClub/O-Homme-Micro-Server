package com.msaclub.test.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @GetMapping("/api/{id}")
    public String testApi(@PathVariable String id){
        log.info("전달된 값은 {} 입니다. ", id);
        return "통신 성공";
    }

    @GetMapping("/health-check")
    public String testHealthCheck(){
        log.info("");
        return "통신 성공";
    }


}
