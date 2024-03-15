package com.babelgroup.dtos;

import com.babelgroup.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientDto {
    private String id;
    private String name;
    private String surname;
    private String address;
    private List<Order> orderList;
}