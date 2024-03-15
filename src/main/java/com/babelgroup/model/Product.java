package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    private List<ProductOrder> orderList;
    @ManyToOne
    private List<Menu> menus;
}
