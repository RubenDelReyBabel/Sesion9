package com.babelgroup.service.menu;

import com.babelgroup.dtos.MenuDto;
import com.babelgroup.model.Menu;
import com.babelgroup.model.Product;
import com.babelgroup.model.relations.ProductMenu;
import com.babelgroup.repository.MenuRepository;
import com.babelgroup.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final ProductRepository productRepository;

    public MenuServiceImpl(MenuRepository menuRepository, ProductRepository productRepository) {
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void add(MenuDto dto) {
        Menu menu = new Menu();
        menu.setName(dto.name);
        menuRepository.save(menu);
    }

    @Override
    public void remove(String id) {
        menuRepository.deleteById(id);
    }

    @Override
    public void update(MenuDto dto) {
        Menu menu = menuRepository.findById(dto.id).orElseThrow();

        if (dto.name != null) {
            menu.setName(dto.name);
        }
    }

    @Override
    public void addProduct(String menuId, String productId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();

        ProductMenu.link(product, menu);
    }

    @Override
    public void removeProduct(String menuId, String productId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();

        ProductMenu.unlink(product, menu);
    }

    @Override
    public Menu findById(String menuId) {
        return menuRepository.findById(menuId).orElseThrow();
    }

    @Override
    public MenuDto addMenu(MenuDto dto) {
        Menu menu = new Menu();
        menu.setName(dto.name);

        dto.id = menu.getId();

        return dto;
    }
}
