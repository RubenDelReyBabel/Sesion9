package com.babelgroup.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Store extends BaseEntity {

    private String address;

    private List<Product> productList;
    private List<Worker> workerList;
    private List<Order> orderList;
}
