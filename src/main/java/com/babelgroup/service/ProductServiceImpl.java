package com.babelgroup.service;

import com.babelgroup.model.Product;
import com.babelgroup.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe ningún producto con la ID: " + id));
        if (productDetails.getName() != null)product.setName(productDetails.getName());
        if (productDetails.getDescription() != null) product.setDescription(productDetails.getDescription());
        if (productDetails.getStock() != null) product.setStock(productDetails.getStock());
        if (productDetails.getPrice() != null) product.setPrice(productDetails.getPrice());
        if (productDetails.getStore() != null) product.setStore(productDetails.getStore());
        if (productDetails.getOrderList() != null) product.setOrderList(productDetails.getOrderList());
        if (productDetails.getMenus() != null) product.setMenus(productDetails.getMenus());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe ningún producto con la ID: " + id));
    }

    @Override
    public void deleteProduct(String id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
