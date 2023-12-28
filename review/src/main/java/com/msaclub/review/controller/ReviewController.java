package com.msaclub.review.controller;


import com.msaclub.review.model.ReviewDto;
import com.msaclub.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {

    @Autowired
    ReviewService reviewService;


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
    @GetMapping("/testGetNumberOfPurchaseList")
    public String testGetNumberOfPurchaseList() {

        int number = reviewService.getNumberOfPurchaseList("ssafy");
        log.info(number + "개 구매하였습니다");

        return "testGetNumberOfPurchaseList";
    }



    @GetMapping("/testGetPurchaseListByDate")
    public String testGetPurchaseListByDate() {
        String startString = "2020-01-01 12:34:56";
        String endString = "2023-12-25 12:34:56";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime startTime = LocalDateTime.parse(startString, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endString, formatter);


        List<String> result = reviewService.getPurchaseListByDate("ssafy", Timestamp.valueOf(startTime), Timestamp.valueOf(endTime));
        log.info(result.toString());

        return "testGetPurchaseListByDate";
    }

    @GetMapping("/testGetPurchaseList")
    public String testGetPurchaseList() {
        List<String> result = reviewService.getPurchaseList("ssafy");

        log.info(result.toString());
        return "testGetPurchaseList";
    }

    @GetMapping("/testIsBuyer")
    public String testIsBuyer() {
        boolean isBuyer = reviewService.isBuyer("ssafy", "galaxys23");

        if(isBuyer)
            log.info("true");
        else
            log.info("false");

        return "testIsBuyer";
    }

    /*check*/
    @GetMapping("/testReview")
    public String testReview() {
        boolean result = reviewService.review(1, "내용을 수정하겠습니다");
        if(result) {
            log.info("수정 성공!!");
        } else {
            log.info("수정 실패!!");
        }
        return "testReview";
    }

    /*check*/
    @GetMapping("/testDeleteReview")
    public String testDeleteReview() {
        boolean result = reviewService.deleteReview(1);
        if(result) {
            log.info("성공적으로 삭제하였습니다");
        } else {
            log.info("삭제에 실패했습니다");
        }
        return "testDeleteReview";
    }

    @GetMapping("/testGetReviewByReviewId")
    public String testGetReviewByReviewId() {
        ReviewDto result = reviewService.getReviewByReviewId(1);
        if(result != null) {
            log.info(result.toString());
        } else {
            log.info("조회에 실패했습니다");
        }
        return "testGetReviewByReviewId";
    }
////
    @GetMapping("/testGetReviewCount")
    public String testGetReviewCount() {
        int number = reviewService.getReviewCount("ssafy");
        log.info(number + "개의 리뷰를 작성했습니다");
        return "testGetReviewCount";
    }

    @GetMapping("/testGetReviewByUserId")
    public String testGetReviewByUserId() {
        List<ReviewDto> result = reviewService.getReviewByUserId("ssafy");
        if(result != null) {
            log.info(result.toString());
        } else {
            log.info("조회에 실패했습니다");
        }
        return "testGetReviewByUserId";
    }

    @GetMapping("/testGetReviewByUserIdWithParam")
    public String testGetReviewByUserIdWithParam() {
        int pageNo = 2;
        int reviewPerPage = 3;
        List<ReviewDto> result = reviewService.getReviewByUserIdWithParam("ssafy", pageNo, reviewPerPage);
        if(result != null) {
            log.info(result.toString());
        } else {
            log.info("조회에 실패했습니다");
        }
        return "testGetReviewByUserIdWithParam";
    }

    //
    @GetMapping("/testGetReviewByRating")
    public String testGetReviewByRating() {
        List<ReviewDto> result = reviewService.getReviewByRating("galaxy", true);
        if(result != null) {
            log.info(result.toString());
        } else {
            log.info("조회에 실패했습니다");
        }
        return "testGetReviewByRating";
    }


//
    @GetMapping("/testGetReviewAvg")
    public String testGetReviewAvg() {

        double avgRating = reviewService.getReviewAvg("galaxy");
        log.info(String.valueOf(avgRating));

        return "testGetReviewAvg";
    }
}
