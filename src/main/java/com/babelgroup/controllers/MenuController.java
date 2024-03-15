package com.babelgroup.controllers;

import com.babelgroup.dtos.Assembler;
import com.babelgroup.dtos.MenuDto;
import com.babelgroup.model.Menu;
import com.babelgroup.model.Store;
import com.babelgroup.service.menu.MenuService;
import com.babelgroup.service.store.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {

    private final StoreService storeService;
    private final MenuService menuService;

    public MenuController(StoreService storeService, MenuService menuService) {
        this.storeService = storeService;
        this.menuService = menuService;
    }

    @RequestMapping("/menus/{menuId}")
    public String getMenu(Model model, @PathVariable String menuId) {
        Menu menu = menuService.findById(menuId);
        model.addAttribute("store", menu.getStore());
        model.addAttribute("menu", menu);

        return "/menus/menu";
    }

    @RequestMapping(value = "/stores/{storeId}/menu/add", method = RequestMethod.POST)
    public String addMenu(Model model, @PathVariable String storeId, @Validated MenuDto menu) {
        Store store = storeService.findById(storeId);
        menu.store = Assembler.toStoreDto(store);
        MenuDto result = menuService.addMenu(menu);

        model.addAttribute("store", store);
        model.addAttribute("menu", menu);

        return "/menus/" + result.id;
    }

    @RequestMapping(value = "/stores/{storeId}/menus/{menuId}/products/add/{productId}", method = RequestMethod.POST)
    public String addProduct(Model model, @PathVariable String menuId, @PathVariable String productId) {
        Menu menu = menuService.findById(menuId);
        menuService.addProduct(menuId, productId);

        model.addAttribute("store", menu.getStore());
        model.addAttribute("menu", menu);

        return "/menus/" + menuId;
    }

    @RequestMapping(value = "/stores/{storeId}/menus/{menuId}/products/remove/{productId}", method = RequestMethod.POST)
    public String removeProduct(Model model, @PathVariable String menuId, @PathVariable String productId) {
        Menu menu = menuService.findById(menuId);
        menuService.removeProduct(menuId, productId);

        model.addAttribute("store", menu.getStore());
        model.addAttribute("menu", menu);

        return "/menus/" + menuId;
    }
}
