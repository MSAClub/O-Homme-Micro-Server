package com.msaclub.cart.entity;

import com.msaclub.cart.dto.CartItemSaveDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart-items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    private ObjectId id;

    private Integer productId;

    private Integer count;

    private String userId;

    private boolean deleted = false;

    public void updateQuantity(Integer newQuantity) {
        this.count = newQuantity;
    }
}
