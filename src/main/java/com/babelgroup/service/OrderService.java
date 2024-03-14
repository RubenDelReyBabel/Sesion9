package com.babelgroup.service;

import com.babelgroup.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order updateOrder(String orderId, Order orderDetails);
    List<Order> getAllOrders();
    Order getOrderById(String orderId);
    void deleteOrder(String orderId);
}
