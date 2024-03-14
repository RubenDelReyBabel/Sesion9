package com.babelgroup.service;

import com.babelgroup.model.Order;
import com.babelgroup.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(String orderId, Order orderDetails) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID: " + orderId));
        if (orderDetails.getProductOrderList() != null) order.setProductOrderList(orderDetails.getProductOrderList());
        if (orderDetails.getWorkerList() != null) order.setWorkerList(orderDetails.getWorkerList());
        if (orderDetails.getClient() != null) order.setClient(orderDetails.getClient());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID: " + orderId));
    }

    @Override
    public void deleteOrder(String orderId) {
        Order order = getOrderById(orderId);
        orderRepository.delete(order);
    }
}
