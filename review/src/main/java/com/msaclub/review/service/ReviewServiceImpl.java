package com.msaclub.review.service;

import com.msaclub.review.model.ReviewDto;
import com.msaclub.review.model.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewMapper reviewMapper;


    @Override
    public int getNumberOfPurchaseList(String userId) {
        return reviewMapper.getNumberOfPurchaseList(userId);
    }
  /*
    @Override
    public List<String> getPurchaseListByDate(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public List<String> getPurchaseList(String userId) {
        return null;
    }

    @Override
    public boolean isBuyer(String userId, String productId) {
        return false;
    }

    @Override
    public boolean review(String reviewId, String content) {
        return false;
    }

    @Override
    public boolean deleteReview(String reviewId) {
        return false;
    }

    @Override
    public ReviewDto getReviewByReviewId(String reviewId) {
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
    public List<ReviewDto> getReviewByUserId(String userId, int pageNo, int reviewPerPage) {
        return reviewMapper.getReviewByUserId(userId, pageNo, reviewPerPage);
    }

    @Override
    public List<ReviewDto> getReviewByRating(String productId, boolean isAsending) {
        return reviewMapper.getReviewByRating(productId, isAsending);
    }

    @Override
    public Double getReviewAvg(String productId) {
        return reviewMapper.getReviewAvg(productId);
    }
     */
}
