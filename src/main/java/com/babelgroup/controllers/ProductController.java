package com.babelgroup.controllers;

import com.babelgroup.dtos.ProductDto;
import com.babelgroup.model.Store;
import com.babelgroup.service.ProductService;
import com.babelgroup.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    private ProductService productService;
    private StoreService storeService;

    @RequestMapping("/stores/{storeId}/products/add")
    public String addProduct(Model model, @PathVariable String storeId, @Validated ProductDto product) {
        Store store = storeService.findById(storeId);
        product.store = storeId;
        productService.createProduct(null);
        model.addAttribute("store", store);

        return "products/manage";
    }
}
