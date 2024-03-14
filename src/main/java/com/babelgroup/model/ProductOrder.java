package com.babelgroup.model;

import lombok.Data;

@Data
public class ProductOrder {

    private int quantity;

    private Order order;
    private Product product;
}
