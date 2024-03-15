package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Store extends BaseEntity {

    private String name;
    private String address;

    @OneToMany(mappedBy = "store")
    private List<Product> productList = new ArrayList<>();
    @OneToMany(mappedBy = "store")
    private List<Worker> workerList = new ArrayList<>();
    @OneToMany(mappedBy = "store")
    private List<Order> orderList = new ArrayList<>();
    @OneToMany(mappedBy = "store")
    private List<Menu> menuList = new ArrayList<>();
}
