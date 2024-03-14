package com.babelgroup.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Menu extends BaseEntity {

    private String name;

    private List<Product> productList;
}
