package com.babelgroup.service.order;

import com.babelgroup.dtos.OrderDto;
import com.babelgroup.model.Order;
import com.babelgroup.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(OrderDto orderDetails) {
        Order order = new Order();
        order.setProductOrderList(orderDetails.getProductOrderList());
        order.setWorkerList(orderDetails.getWorkerList());
        order.setClient(orderDetails.getClient());
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(OrderDto orderDetails) {
        Order order = orderRepository.findById(orderDetails.getId()).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID: " + orderDetails.getId()));
        if (orderDetails.getProductOrderList() != null) order.setProductOrderList(orderDetails.getProductOrderList());
        if (orderDetails.getWorkerList() != null) order.setWorkerList(orderDetails.getWorkerList());
        if (orderDetails.getClient() != null) order.setClient(orderDetails.getClient());
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> new OrderDto(order.getId(), order.getProductOrderList(), order.getWorkerList(), order.getClient())).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID: " + orderId));
        return new OrderDto(order.getId(), order.getProductOrderList(), order.getWorkerList(), order.getClient());
    }

    @Override
    public void deleteOrder(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID: " + orderId));
        orderRepository.delete(order);
    }
}
