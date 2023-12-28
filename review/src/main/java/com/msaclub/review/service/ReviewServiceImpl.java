package com.msaclub.review.service;

import com.msaclub.review.model.ReviewDto;
import com.msaclub.review.model.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewMapper reviewMapper;


    @Override
    public int getNumberOfPurchaseList(String userId) {
        return reviewMapper.getNumberOfPurchaseList(userId);
    }


    @Override
    public List<String> getPurchaseListByDate(String userId, Timestamp start, Timestamp end) {

        return reviewMapper.getPurchaseListByDate(userId, start, end);
    }


    @Override
    public List<String> getPurchaseList(String userId) {
        return reviewMapper.getPurchaseList(userId);
    }

    @Override
    public boolean isBuyer(String userId, String productId) {
        return reviewMapper.isBuyer(userId, productId);
    }

    @Override
    public boolean review(int reviewId, String content) {
        return reviewMapper.review(reviewId, content);
    }

    @Override
    public boolean deleteReview(int reviewId) {
        return reviewMapper.deleteReview(reviewId);
    }

    @Override
    public ReviewDto getReviewByReviewId(int reviewId) {
        return reviewMapper.getReviewByReviewId(reviewId);
    }

    @Override
    public int getReviewCount(String userId) {
        return reviewMapper.getReviewCount(userId);
    }

    @Override
    public List<ReviewDto> getReviewByUserId(String userId) {
        return reviewMapper.getReviewByUserId(userId);
    }

    @Override
    public List<ReviewDto> getReviewByUserIdWithParam(String userId, int pageNo, int reviewPerPage) {
        return reviewMapper.getReviewByUserIdWithParam(userId, pageNo, reviewPerPage);
    }

    @Override
    public List<ReviewDto> getReviewByRating(String productId, boolean isAsending) {
        return reviewMapper.getReviewByRating(productId, isAsending);
    }

    @Override
    public double getReviewAvg(String productId) {
        return reviewMapper.getReviewAvg(productId);
    }

}
