package com.msaclub.cart.service;

import com.msaclub.cart.entity.CartItem;
import com.msaclub.cart.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    /**
     * DB에 cartItem 저장 후 자동 생성된 ID 값 반환시키는 메서드
     * @param cartItem
     * @return
     */
    @Override
    public ObjectId createCartItem(CartItem cartItem){
        return cartRepository.save(cartItem).getId();
    }

    /**
     * DB에 저장된 내 장바구니 목록 가져오기
     * @param userId
     * @return
     */
    @Override
    public List<CartItem> findByCartItemList(String userId) {
        return cartRepository.findByUserIdAndDeletedIsFalse(userId);
    }

    /**
     * DB 저장된 내 장바구니 물품 수량 변경
     * @param cartItemId
     * @return
     */
    @Override
    public boolean updateCartItemCount(String cartItemId, Integer newQuantity) {
        Optional<CartItem> optionalCartItem = cartRepository.findById(cartItemId);
        log.info("Find CartItem Value : {}", optionalCartItem.get());
        optionalCartItem.ifPresent(cartItem -> {
            cartItem.updateQuantity(newQuantity);
            cartRepository.save(cartItem);
        });
        return true;
    }

    /**
     * 내 장바구니 물품 삭제
     * @param cartItemId
     */
    @Override
    public boolean deleteCartItem(String cartItemId) {
        Optional<CartItem> optionalCartItem = cartRepository.findById(cartItemId);
        optionalCartItem.ifPresent(cartItem -> {
            cartItem.setDeleted(true); // 삭제 여부 플래그를 true
            cartRepository.save(cartItem);
        });
        return true;
    }

}
