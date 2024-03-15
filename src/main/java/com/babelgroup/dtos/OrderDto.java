package com.babelgroup.dtos;

import com.babelgroup.model.Client;
import com.babelgroup.model.ProductOrder;
import com.babelgroup.model.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderDto {
    private String id;
    private List<ProductOrder> productOrderList;
    private List<Worker> workerList;
    private Client client;
}
