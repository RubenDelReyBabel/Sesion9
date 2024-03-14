package com.babelgroup.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Worker extends BaseEntity {

    private String name;

    private Store store;
    private List<Order> orderList;
}
