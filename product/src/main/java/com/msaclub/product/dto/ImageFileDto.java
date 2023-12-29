package com.msaclub.product.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ImageFileDto {

    private Long product_code;
    private String file_path;
    private int file_order;
}
