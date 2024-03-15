package com.babelgroup.dtos;

import com.babelgroup.model.*;

import java.util.List;

public class Assembler {
    public static List<Order> toOrderList(List<OrderDto> orderListDto) {
        return orderListDto.stream().map(Assembler::toOrder).toList();
    }

    public static Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.id);
        order.setClient(toClient(orderDto.client));
        order.setProductOrderList(toProductOrderList(orderDto.productOrderList));
        return order;
    }

    public static List<ProductOrder> toProductOrderList(List<ProductOrderDto> productOrderList) {
        return productOrderList.stream().map(Assembler::toProductOrder).toList();
    }

    public static ProductOrder toProductOrder(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setQuantity(productOrderDto.quantity);
        productOrder.setOrder(toOrder(productOrderDto.order));
        productOrder.setProduct(toProduct(productOrderDto.product));
        return productOrder;
    }

    public static Product toProduct(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.id);
        product.setName(dto.name);
        product.setPrice(dto.price);
        product.setStore(toStore(dto.store));
        return product;
    }

    public static Store toStore(StoreDto storeDto) {
        Store store = new Store();
        store.setId(storeDto.id);
        store.setName(storeDto.name);
        store.setAddress(storeDto.address);
        store.setProductList(toProductList(storeDto.productList));
        store.setWorkerList(toWorkerList(storeDto.workerList));
        return store;
    }

    public static List<Worker> toWorkerList(List<WorkerDto> workerList) {
        return workerList.stream().map(Assembler::toWorker).toList();
    }

    public static Worker toWorker(WorkerDto workerDto) {
        Worker worker = new Worker();
        worker.setId(workerDto.id);
        worker.setName(workerDto.name);
        worker.setSurname(workerDto.surname);
        worker.setMonthlySalary(workerDto.monthlySalary);
        worker.setStore(toStore(workerDto.store));
        worker.setOrderList(toOrderList(workerDto.orderList));
        return worker;
    }

    public static List<Product> toProductList(List<ProductDto> productList) {
        return productList.stream().map(Assembler::toProduct).toList();
    }

    public static Client toClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.id);
        client.setName(clientDto.name);
        client.setSurname(clientDto.surname);
        client.setAddress(clientDto.address);
        client.setOrderList(toOrderList(clientDto.orderList));
        return client;
    }

    public static WorkerDto toWorkerDto(Worker worker) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.id = worker.getId();
        workerDto.name = worker.getName();
        workerDto.surname = worker.getSurname();
        workerDto.monthlySalary = worker.getMonthlySalary();
        workerDto.store = toStoreDto(worker.getStore());
        workerDto.orderList = toOrderListDto(worker.getOrderList());
        return workerDto;
    }

    public static StoreDto toStoreDto(Store store) {
        StoreDto storeDto = new StoreDto();
        storeDto.id = store.getId();
        storeDto.name = store.getName();
        storeDto.address = store.getAddress();
        storeDto.productList = toProductListDto(store.getProductList());
        storeDto.workerList = toWorkerListDto(store.getWorkerList());
        return storeDto;
    }

    public static List<WorkerDto> toWorkerListDto(List<Worker> workerList) {
        return workerList.stream().map(Assembler::toWorkerDto).toList();
    }

    public static List<ProductDto> toProductListDto(List<Product> productList) {
        return productList.stream().map(Assembler::toProductDto).toList();
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.id = product.getId();
        productDto.name = product.getName();
        productDto.price = product.getPrice();
        productDto.store = toStoreDto(product.getStore());
        return productDto;
    }

    public static List<OrderDto> toOrderListDto(List<Order> orderList) {
        return orderList.stream().map(Assembler::toOrderDto).toList();
    }

    public static OrderDto toOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.id = order.getId();
        orderDto.client = toClientDto(order.getClient());
        return orderDto;
    }

    public static ClientDto toClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.id = client.getId();
        clientDto.name = client.getName();
        clientDto.surname = client.getSurname();
        clientDto.address = client.getAddress();
        clientDto.orderList = toOrderListDto(client.getOrderList());
        return clientDto;
    }
}
