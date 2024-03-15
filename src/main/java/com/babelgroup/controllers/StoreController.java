package com.babelgroup.controllers;

import com.babelgroup.model.Store;
import com.babelgroup.service.store.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping("/stores/list")
    public String getStores(Model model) {
        List<Store> storeList = storeService.findAll();
        model.addAttribute("storeList", storeList);

        return "stores/list";
    }


    @RequestMapping("/stores/{id}/products/manage")
    public String manageProducts(Model model, @PathVariable String id) {
        Store store = storeService.findById(id);
        model.addAttribute("store", store);

        return "products/manage";
    }

    @RequestMapping("/stores/{id}/workers/manage")
    public String manageWorkers(Model model, @PathVariable String id) {
        Store store = storeService.findById(id);
        model.addAttribute("store", store);

        return "workers/manage";
    }

    @RequestMapping("/stores/{id}/menus/manage")
    public String manageMenus(Model model, @PathVariable String id) {
        Store store = storeService.findById(id);
        model.addAttribute("store", store);

        return "menus/manage";
    }

    @RequestMapping("/stores/{id}/orders/manage")
    public String manageOrders(Model model, @PathVariable String id) {
        Store store = storeService.findById(id);
        model.addAttribute("store", store);

        return "orders/manage";
    }
}
