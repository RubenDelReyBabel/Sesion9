package com.babelgroup.service.init;

import com.babelgroup.model.Menu;
import com.babelgroup.model.Product;
import com.babelgroup.model.Store;
import com.babelgroup.model.Worker;
import com.babelgroup.model.relations.StoreProduct;
import com.babelgroup.model.relations.StoreWorker;
import com.babelgroup.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInitServiceImpl implements DataInitService {
    private final ClientRepository clientRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final WorkerRepository workerRepository;

    public DataInitServiceImpl(ClientRepository clientRepository, MenuRepository menuRepository, OrderRepository orderRepository, ProductRepository productRepository, StoreRepository storeRepository, WorkerRepository workerRepository) {
        this.clientRepository = clientRepository;
        this.menuRepository = menuRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.workerRepository = workerRepository;
    }

    public void initData() {
        initStore();
        initProduct();
        initMenu();
        initWorker();
    }

    private void initStore() {
        Store store1 = new Store();
        store1.setName("The Store 1");
        store1.setAddress("The Store 1 Address");
        storeRepository.save(store1);

        Store store2 = new Store();
        store2.setName("The Store 2");
        store2.setAddress("The Store 2 Address");
        storeRepository.save(store2);

        Store store3 = new Store();
        store3.setName("The Store 3");
        store3.setAddress("The Store 3 Address");
        storeRepository.save(store3);

        Store store4 = new Store();
        store4.setName("The Store 4");
        store4.setAddress("The Store 4 Address");
        storeRepository.save(store4);

        Store store5 = new Store();
        store5.setName("The Store 5");
        store5.setAddress("The Store 5 Address");
        storeRepository.save(store5);
    }

    private void initProduct() {
        List<Store> stores = storeRepository.findAll();
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setDescription("The Product 1 description");
        product1.setStock(12);
        product1.setPrice(10.99);
        StoreProduct.link(stores.get(0), product1);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("The Product 2 description");
        product2.setStock(23);
        product2.setPrice(16.99);
        StoreProduct.link(stores.get(1), product2);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDescription("The Product 3 description");
        product3.setStock(2);
        product3.setPrice(24.50);
        StoreProduct.link(stores.get(2), product3);
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setName("Product 4");
        product4.setDescription("The Product 4 description");
        product4.setStock(25);
        product4.setPrice(56.33);
        StoreProduct.link(stores.get(3), product4);
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setName("Product 5");
        product5.setDescription("The Product 5 description");
        product5.setStock(998);
        product5.setPrice(4.55);
        StoreProduct.link(stores.get(4), product5);
        productRepository.save(product5);
    }

    private void initMenu() {
        Menu menu1 = new Menu();
        menu1.setName("Menú mediodía :D");
        menuRepository.save(menu1);

        Menu menu2 = new Menu();
        menu2.setName("Menú Noche >:)");
        menuRepository.save(menu2);
    }

    private void initWorker() {
        List<Store> stores = storeRepository.findAll();
        Worker worker1 = new Worker();
        worker1.setName("Trabajador 1");
        worker1.setSurname("Apellido 1");
        worker1.setMonthlySalary(33);
        StoreWorker.link(stores.get(0), worker1);
        workerRepository.save(worker1);

        Worker worker2 = new Worker();
        worker2.setName("Trabajador 2");
        worker2.setSurname("Apellido 2");
        worker2.setMonthlySalary(1000);
        StoreWorker.link(stores.get(1), worker2);
        workerRepository.save(worker2);

        Worker worker3 = new Worker();
        worker3.setName("Trabajador 3");
        worker3.setSurname("Apellido 3");
        worker3.setMonthlySalary(250);
        StoreWorker.link(stores.get(2), worker3);
        workerRepository.save(worker3);

        Worker worker4 = new Worker();
        worker4.setName("Trabajador 4");
        worker4.setSurname("Apellido 4");
        worker4.setMonthlySalary(300);
        StoreWorker.link(stores.get(3), worker4);
        workerRepository.save(worker4);

        Worker worker5 = new Worker();
        worker5.setName("Trabajador 4");
        worker5.setSurname("Apellido 4");
        worker5.setMonthlySalary(150);
        StoreWorker.link(stores.get(4), worker5);
        workerRepository.save(worker5);
    }
}
