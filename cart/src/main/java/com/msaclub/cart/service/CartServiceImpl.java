package com.msaclub.cart.service;

import com.msaclub.cart.entity.CartItem;
import com.msaclub.cart.repository.CartRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return cartRepository.findAllByUserId(userId);
    }


}
