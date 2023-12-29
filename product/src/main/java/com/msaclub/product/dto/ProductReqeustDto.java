package com.msaclub.product.dto;


import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@ToString
public class ProductReqeustDto {
    //product
    private String subject, content,thumbnail,seller;
    private int price,stock;
    private Long productCode;

    //category
    private int category_code;

    //imageFile
    private List<ImageFileDto> imageFiles;
}
