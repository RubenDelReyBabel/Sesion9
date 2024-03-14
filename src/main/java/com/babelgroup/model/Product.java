package com.babelgroup.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Product extends BaseEntity {

    private String name;
    private String description;
    private Integer stock;
    private Double price;

    private Store store;
    private List<ProductOrder> orderList;
    private List<Menu> menus;
}
