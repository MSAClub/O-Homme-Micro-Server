package com.msaclub.cart.controller;

import com.msaclub.cart.dto.CartItemSaveDto;
import com.msaclub.cart.entity.CartItem;
import com.msaclub.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    임시로 userId가 존재하지 않기 때문에 파라미터 형태로 넘겨주기.
    나중에 JWT 토큰을 통해 해결해야 됨.
    지금은 단순 TEST

    의존 관계 주입은 직접 주입이 아닌 생성자를 통한 주입으로 lego
 */
@RestController
@Slf4j
public class CartController {

    private final CartService cartService;

    private final ModelMapper modelMapper;

    @Autowired
    public CartController(CartService cartService, ModelMapper modelMapper){
        this.cartService = cartService;
        this.modelMapper = modelMapper;
    }

    /**
     * 내 장바구니에 상품을 추가할 때
     * @param userId
     * @param cartItemSaveDto
     * @return
     */
    @PostMapping("/cart/{userId}")
    public String createCartItem(@PathVariable String userId, @RequestBody CartItemSaveDto cartItemSaveDto){

        // convert DTO to Entity
        CartItem cartItem = modelMapper.map(cartItemSaveDto, CartItem.class);
        cartItem.setUserId(userId);
        log.info("created cartItem entity : {}", cartItem);


        // call service
        ObjectId id = cartService.createCartItem(cartItem);
        return String.valueOf(id);
    }

    /**
     * 내 장바구니 리스트를 보여줄 때
     * @param userId
     * @return
     */
    @GetMapping("/cart/{userId}")
    public String findByCartItemList(@PathVariable String userId){
        List<CartItem> cartItemList = cartService.findByCartItemList(userId);
        for (CartItem item: cartItemList) {
            log.info("cartItem : {}", item);
        }
        return String.valueOf(cartItemList);
    }
}
