package com.msaclub.order.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id; // 주문ID

    @Column(nullable = false, length = 120, unique = true)
    private String productId; // 상품ID
    @Column(nullable = false)
    private Integer qty; // 수량
    @Column(nullable = false)
    private Integer unitPrice; // 개당 가격
    @Column(nullable = false)
    private Integer totalPrice; // 전체 가격
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;

    @Column(nullable = false, updatable = false, insertable = false)
    private Date createdAt; // 생성시간
}
