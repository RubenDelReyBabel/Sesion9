package com.babelgroup.service.store;

import com.babelgroup.model.Product;
import com.babelgroup.model.Store;
import com.babelgroup.repository.ProductRepository;
import com.babelgroup.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public StoreServiceImpl(ProductRepository productRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public Product addProductToStore(String storeId, Product product) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("No existe ninguna store con la ID: " + storeId));
        product.setStore(store);
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllProductsInStore(String storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("No existe ninguna store con la ID: " + storeId));
        return new ArrayList<>(store.getProductList());
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store findById(String id) {
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe ninguna store con la ID: " + id));
    }
}
