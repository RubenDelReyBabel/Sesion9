package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Menu extends BaseEntity {

    private String name;

    @ManyToMany
    private List<Product> productList = new ArrayList<>();
    @ManyToOne
    private Store store;
}
