package com.msaclub.order.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="order_detail")
@Getter
@Setter
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderDetailId; // 주문ID

    @Column(nullable = false, unique = true)
    private String orderId;
    @Column(nullable = false, length = 120, unique = true)
    private long productId; // 상품ID
    @Column(nullable = false, length = 120, unique = true)
    private String productName; // 상품이름
    @Column(nullable = false)
    private Integer qty; // 수량
    @Column(nullable = false)
    private Integer unitPrice; // 개당 가격
}
