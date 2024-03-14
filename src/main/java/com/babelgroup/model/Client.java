package com.babelgroup.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Client extends BaseEntity {

    private String name;
    private String surname;
    private String address;

    private List<Order> orderList;
}
