package com.msaclub.review.model.mapper;

import com.msaclub.review.model.ReviewDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
public interface ReviewMapper {


    int getNumberOfPurchaseList(String userId);

    List<String> getPurchaseListByDate(LocalDateTime start, LocalDateTime end);

    List<String> getPurchaseList(String userId);

    boolean isBuyer(String userId, String productId);

    boolean review(String reviewId, String content);

    boolean deleteReview(String reviewId);

    ReviewDto getReviewByReviewId(String reviewId);

    int getReviewCount(String userId);

    List<ReviewDto> getReviewByUserId(String userId);

    List<ReviewDto> getReviewByUserId(String userId, int pageNo, int reviewPerPage);

    List<ReviewDto> getReviewByUserIdPaged(String userId, int offset, int limit);

    List<ReviewDto> getReviewByRating(String productId, boolean isAscending);

    Double getReviewAvg(String productId);
}
