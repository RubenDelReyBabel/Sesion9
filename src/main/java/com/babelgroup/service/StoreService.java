package com.babelgroup.service;

import com.babelgroup.model.Product;
import com.babelgroup.model.Store;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StoreService {
    Product addProductToStore(String storeId, Product product);
    List<Product> findAllProductsInStore(String storeId);

    List<Store> findAll();

    Store findById(String id);
}
