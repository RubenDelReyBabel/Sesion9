package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ProductOrder extends BaseEntity {

    private int quantity;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
