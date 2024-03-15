package com.babelgroup.dtos;

import java.util.List;

public class OrderDto {
    public String id;
    public List<ProductOrderDto> productOrderList;
    public List<WorkerDto> workerList;
    public ClientDto client;
}
