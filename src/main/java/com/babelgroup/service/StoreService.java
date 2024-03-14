package com.babelgroup.service;

import com.babelgroup.model.Product;

import java.util.List;

public interface StoreService {
    Product addProductToStore(String storeId, Product product);
    List<Product> findAllProductsInStore(String storeId);
}
