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
public class Client extends BaseEntity {
    private String name;
    private String surname;
    private String address;

    @OneToMany(mappedBy = "client")
    private List<Order> orderList = new ArrayList<>();
}
