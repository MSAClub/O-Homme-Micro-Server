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
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="order")
@Getter @Setter
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId; // 주문ID

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Integer totalPrice; // 전체 가격

    @Column(nullable = false, unique = true)
    private String paymentId;

    @Column(nullable = false, updatable = false, insertable = false)
    private Date createdAt; // 생성시간
}
