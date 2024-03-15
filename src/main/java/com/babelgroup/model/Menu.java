package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Menu extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "menu")
    private List<Product> productList;
}
