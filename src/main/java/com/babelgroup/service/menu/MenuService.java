package com.babelgroup.service.menu;

import com.babelgroup.dtos.MenuDto;
import com.babelgroup.model.Menu;

public interface MenuService {

    void add(MenuDto dto);

    void remove(String id);

    void update(MenuDto dto);

    void addProduct(String menuId, String productId);

    void removeProduct(String menuId, String productId);

    Menu findById(String menuId);

    MenuDto addMenu(MenuDto menu);
}
