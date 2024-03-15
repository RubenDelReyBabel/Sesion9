package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Product extends BaseEntity {

    private String name;
    private String description;
    private Integer stock;
    private Double price;

    @ManyToOne
    private Store store;
    @OneToMany(mappedBy = "product")
    private List<ProductOrder> orderList = new ArrayList<>();
    @ManyToMany
    private List<Menu> menuList = new ArrayList<>();
}
