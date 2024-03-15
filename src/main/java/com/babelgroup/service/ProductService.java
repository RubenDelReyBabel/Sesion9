package com.babelgroup.service;

import com.babelgroup.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(String id, Product productDetails);

    List<Product> getAllProducts();

    Product getProductById(String id);

    void deleteProduct(String id);

    Product findById(String productId);
}
