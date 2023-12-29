package com.msaclub.review.service;

import com.msaclub.review.model.ReviewDto;

import java.sql.Timestamp;
import java.util.List;

public interface ReviewService {


    // 현재 구매자의 구매 목록 갯수 가져오기
    int getNumberOfPurchaseList(String userId);

    // 현재 구매자의 날짜별 구매 목록 가져오기
    List<String> getPurchaseListByDate(String userId, Timestamp start, Timestamp end);


    // 현재 구매자의 구매 리스트 가져오기
    List<String> getPurchaseList(String userId);

    // 현재 댓글 쓰기 기능을 요청한 사용자가 구매자가 맞나 판별
    boolean isBuyer(String userId, String productId);

    // 리뷰 수정
    boolean review(int reviewId, String content);

    // 리뷰 삭제
    boolean deleteReview(int reviewId);

    // 리뷰 조회 (by reviewId)
    ReviewDto getReviewByReviewId(int reviewId);

    // 어떤 유저가 작성한 리뷰 갯수 반환하기
    int getReviewCount(String userId);

    // 리뷰 조회 (by userId)
    List<ReviewDto> getReviewByUserId(String userId);

    // 리뷰 조회
    List<ReviewDto> getReviewByUserIdWithParam(String userId, int pageNo, int reviewPerPage);

    // 리뷰 점수 순으로 조회하기
    List<ReviewDto> getReviewByRating(String productId, boolean isAsending);

    // 리뷰 평점 계산하기
    double getReviewAvg(String productId);




}
