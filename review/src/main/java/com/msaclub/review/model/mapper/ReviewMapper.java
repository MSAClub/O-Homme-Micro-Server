package com.msaclub.review.model.mapper;

import com.msaclub.review.model.ReviewDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface ReviewMapper {

    int getNumberOfPurchaseList(String userId);


    List<String> getPurchaseListByDate(@Param("userId") String userId, @Param("start") Timestamp start, @Param("end") Timestamp end);

    List<String> getPurchaseList(String userId);

    boolean isBuyer(String userId, String productId);

    boolean review(int reviewId, String content);

    boolean deleteReview(int reviewId);

    ReviewDto getReviewByReviewId(int reviewId);

    int getReviewCount(String userId);

    List<ReviewDto> getReviewByUserId(String userId);

    List<ReviewDto> getReviewByUserIdWithParam(String userId, int pageNo, int reviewPerPage);

    List<ReviewDto> getReviewByRating(String productId, boolean isAscending);


    double getReviewAvg(String productId);




}
