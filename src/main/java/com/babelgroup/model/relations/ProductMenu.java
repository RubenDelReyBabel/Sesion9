package com.babelgroup.model.relations;

import com.babelgroup.model.Menu;
import com.babelgroup.model.Product;

public class ProductMenu {

    public static void link(Product product, Menu menu) {
        product.getMenuList().add(menu);
        menu.getProductList().add(product);
    }

    public static void unlink(Product product, Menu menu) {
        product.getMenuList().remove(menu);
        menu.getProductList().remove(product);
    }
}
