package com.msaclub.cart.service;

import com.msaclub.cart.entity.CartItem;
import org.bson.types.ObjectId;

import java.util.List;

public interface CartService {
    ObjectId createCartItem(CartItem cartItem);
    List<CartItem> findByCartItemList(String userId);
    boolean updateCartItemCount(String cartItemId, Integer newQuantity);
}
