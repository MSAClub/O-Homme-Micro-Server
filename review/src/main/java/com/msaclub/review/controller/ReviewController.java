package com.msaclub.review.controller;


import com.msaclub.review.service.ReviewService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/test")
    public String test() {
        return "hello review";
    }

    @GetMapping("/DBConnectionTest")
    public String testConnection() {
        try {
            int number = reviewService.getNumberOfPurchaseList("ssafy");
            return "조회 성공";
        } catch(Exception e) {
            System.out.println(e);
            return "DB Connection Error : 로그 메시지 참고해주세요";
        }
    }
}
