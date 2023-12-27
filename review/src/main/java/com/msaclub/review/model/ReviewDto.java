package com.msaclub.review.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ReviewDto {

    private String reviewId;
    private String userId;
    private String productId;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean deleted;
}
