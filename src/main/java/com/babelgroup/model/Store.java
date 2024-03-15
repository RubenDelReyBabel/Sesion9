package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Store extends BaseEntity {

    private String name;
    private String address;

    @OneToMany(mappedBy = "store")
    private List<Product> productList;
    @OneToMany(mappedBy = "store")
    private List<Worker> workerList;
    @OneToMany(mappedBy = "store")
    private List<Order> orderList;
}
