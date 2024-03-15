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
public class Order extends BaseEntity {
    @OneToMany(mappedBy = "order")
    private List<ProductOrder> productOrderList = new ArrayList<>();
    @ManyToMany
    private List<Worker> workerList = new ArrayList<>();
    @ManyToOne
    private Client client;
    @ManyToOne
    private Store store;
}
