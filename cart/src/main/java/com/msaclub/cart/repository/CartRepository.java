package com.msaclub.cart.repository;

import com.msaclub.cart.entity.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<CartItem, String> {
    List<CartItem> findAllByUserId(String userId);
}
