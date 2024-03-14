package com.babelgroup.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Order extends BaseEntity {

    private List<ProductOrder> productOrderList;
    private List<Worker> workerList;
    private Client client;
}
