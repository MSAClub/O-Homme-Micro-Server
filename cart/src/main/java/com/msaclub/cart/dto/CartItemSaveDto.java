package com.msaclub.cart.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemSaveDto {
    @Schema(description = "상품 아이디")
    private Integer productId;
    @Schema(description = "상품 수량", nullable = false)
    private Integer count;
}
