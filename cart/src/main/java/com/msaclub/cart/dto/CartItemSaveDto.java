package com.msaclub.cart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemSaveDto {

    private Integer productId;
    private Integer count;
}
