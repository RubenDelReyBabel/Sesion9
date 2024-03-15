package com.babelgroup.service.store;

import com.babelgroup.model.Product;
import com.babelgroup.model.Store;

import java.util.List;

public interface StoreService {
    Product addProductToStore(String storeId, Product product);

    List<Product> findAllProductsInStore(String storeId);

    List<Store> findAll();

    Store findById(String id);
}
