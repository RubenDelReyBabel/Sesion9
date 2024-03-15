package com.babelgroup.service.menu;

import com.babelgroup.dtos.MenuDto;

public interface MenuService {

    void add(MenuDto dto);
    void remove(String id);
    void update(MenuDto dto);
    void addProduct(String menuId, String productId);
    void removeProduct(String menuId, String productId);
}
