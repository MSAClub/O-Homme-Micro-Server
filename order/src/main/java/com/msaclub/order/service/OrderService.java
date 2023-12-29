package com.msaclub.order.service;

import com.msaclub.order.dto.OrderDto;
import com.msaclub.order.jpa.OrderEntity;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String UserId);
}
