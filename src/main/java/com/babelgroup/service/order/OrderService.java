package com.babelgroup.service.order;

import com.babelgroup.dtos.OrderDto;
import com.babelgroup.model.Order;

import java.util.List;

public interface OrderService {
    void createOrder(OrderDto orderDetails);
    void updateOrder(OrderDto orderDetails);
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(String orderId);
    void deleteOrder(String orderId);
}
