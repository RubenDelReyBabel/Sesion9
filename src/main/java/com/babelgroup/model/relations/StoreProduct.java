package com.babelgroup.model.relations;

import com.babelgroup.model.Product;
import com.babelgroup.model.Store;

public class StoreProduct {

    public static void link(Store store, Product product) {
        store.getProductList().add(product);
        product.setStore(store);
    }

    public static void unlink(Store store, Product product) {
        store.getProductList().remove(product);
        product.setStore(null);
    }
}
