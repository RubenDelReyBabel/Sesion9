package com.babelgroup.dtos;

import com.babelgroup.model.Order;
import com.babelgroup.model.Store;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WorkerDto {
    private String id;
    private String name;
    private String surname;
    private double monthlySalary;
    private Store store;
    private List<Order> orderList;
}
