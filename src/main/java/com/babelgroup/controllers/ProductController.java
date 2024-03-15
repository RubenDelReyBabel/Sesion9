package com.babelgroup.controllers;

import com.babelgroup.dtos.Assembler;
import com.babelgroup.dtos.ProductDto;
import com.babelgroup.model.Store;
import com.babelgroup.service.product.ProductService;
import com.babelgroup.service.store.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private final ProductService productService;
    private final StoreService storeService;

    public ProductController(ProductService productService, StoreService storeService) {
        this.productService = productService;
        this.storeService = storeService;
    }

    @RequestMapping(value = "/stores/{storeId}/products/add", method = RequestMethod.POST)
    public String addProduct(Model model, @PathVariable String storeId, @Validated ProductDto product) {
        Store store = storeService.findById(storeId);
        product.store = Assembler.toStoreDto(store);
        productService.createProduct(product);
        model.addAttribute("store", store);

        return "products/manage";
    }

    @RequestMapping("/stores/{storeId}/products/remove/{productId}")
    public String removeProduct(Model model, @PathVariable String storeId, @PathVariable String productId) {
        Store store = storeService.findById(storeId);
        productService.deleteProduct(productId);
        model.addAttribute("store", store);

        return "products/manage";
    }
}
