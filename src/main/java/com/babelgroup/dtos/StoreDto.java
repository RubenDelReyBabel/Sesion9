package com.babelgroup.dtos;

import java.util.List;

public class StoreDto {
    public String id;
    public String name;
    public String address;
    public List<ProductDto> productList;
    public List<WorkerDto> workerList;
    public List<OrderDto> orderList;
    public List<MenuDto> menuList;
}
