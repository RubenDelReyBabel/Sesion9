package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ProductOrder {

    private int quantity;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
