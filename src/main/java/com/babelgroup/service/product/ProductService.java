package com.babelgroup.service.product;

import com.babelgroup.dtos.ProductDto;
import com.babelgroup.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDto product);

    Product updateProduct(String id, Product productDetails);

    List<Product> getAllProducts();

    Product getProductById(String id);

    void deleteProduct(String id);

    Product findById(String productId);
}
