package com.babelgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Worker extends BaseEntity {

    private String name;
    private String surname;
    private double monthlySalary;

    @ManyToOne
    private Store store;
    @ManyToMany
    private List<Order> orderList;
}
