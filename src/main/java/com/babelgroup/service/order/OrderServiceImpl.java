package com.babelgroup.service.order;

import com.babelgroup.dtos.Assembler;
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
        order.setProductOrderList(Assembler.toProductOrderList(orderDetails.productOrderList));
        order.setWorkerList(Assembler.toWorkerList(orderDetails.workerList));
        order.setClient(Assembler.toClient(orderDetails.client));
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(OrderDto orderDetails) {
        Order order = orderRepository.findById(orderDetails.id).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID: " + orderDetails.id));
        if (orderDetails.productOrderList != null)
            order.setProductOrderList(Assembler.toProductOrderList(orderDetails.productOrderList));
        if (orderDetails.workerList != null) order.setWorkerList(Assembler.toWorkerList(orderDetails.workerList));
        if (orderDetails.client != null) order.setClient(Assembler.toClient(orderDetails.client));
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(Assembler::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID: " + orderId));
        return Assembler.toOrderDto(order);
    }

    @Override
    public void deleteOrder(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID: " + orderId));
        orderRepository.delete(order);
    }
}
