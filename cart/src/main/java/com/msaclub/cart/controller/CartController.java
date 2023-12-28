package com.msaclub.cart.controller;

import com.msaclub.cart.dto.CartItemSaveDto;
import com.msaclub.cart.entity.CartItem;
import com.msaclub.cart.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
@Tag(name = "Cart", description = "장바구니 API")
public class CartController {

    private final CartService cartService;

    private final ModelMapper modelMapper;

    // test 용도 나중에 지울거임.
    private final Environment env;

    @Autowired
    public CartController(CartService cartService, ModelMapper modelMapper, Environment env){
        this.cartService = cartService;
        this.modelMapper = modelMapper;
        this.env = env;
    }

    @Operation(summary = "장바구니 물건 등록", description = "내 장바구니에 물건을 등록하기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "장바구니에 물건 등록 성공", content = {
                    @Content(mediaType = "application/text")
            }),
            @ApiResponse(responseCode = "400", description = "넘어온 데이터 값 이상", content = {
                    @Content()
            }),
    })
    @PostMapping("/cart/{userId}")
    public String createCartItem(@Parameter(description = "유저 아이디") @PathVariable String userId,
                                 @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "test")@RequestBody CartItemSaveDto cartItemSaveDto){

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

    /**
     * 내 장바구니 내 물품 수량 변경
     * @param cartItemId
     * @return
     */
    @PatchMapping("/cart/{cartItemId}")
    public String updateCartItemCount(@PathVariable String cartItemId, @RequestBody Integer newQuantity){
        cartService.updateCartItemCount(cartItemId, newQuantity);
        return "ok";
    }


    @GetMapping("/health")
    public String health(){
        log.info("spring app name : {}", env.getProperty("spring.application.name"));
        log.info("mongo DB uri : {}", env.getProperty("spring.data.mongodb.uri"));
        return "";
    }

    /**
     * 내 장바구니 내 물품 수량 변경
     * @param cartItemId
     * @return
     */
    @DeleteMapping("/cart/{cartItemId}")
    public String deleteCartItem(@PathVariable String cartItemId){
        cartService.deleteCartItem(cartItemId);
        return "ok";
    }
}
