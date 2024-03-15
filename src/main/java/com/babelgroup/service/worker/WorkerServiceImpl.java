package com.babelgroup.service.worker;

import com.babelgroup.dtos.Assembler;
import com.babelgroup.dtos.WorkerDto;
import com.babelgroup.model.Order;
import com.babelgroup.model.Store;
import com.babelgroup.model.Worker;
import com.babelgroup.repository.OrderRepository;
import com.babelgroup.repository.StoreRepository;
import com.babelgroup.repository.WorkerRepository;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final OrderRepository orderRepository;
    private final StoreRepository storeRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository, OrderRepository orderRepository, StoreRepository storeRepository) {
        this.workerRepository = workerRepository;
        this.orderRepository = orderRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public void createWorker(WorkerDto workerDetails) {
        Worker worker = new Worker();
        worker.setName(workerDetails.name);
        worker.setSurname(workerDetails.surname);
        worker.setMonthlySalary(workerDetails.monthlySalary);
        Store store = storeRepository.findById(workerDetails.store.id).orElseThrow();
        worker.setStore(store);
        worker.setOrderList(Assembler.toOrderList(workerDetails.orderList));
        workerRepository.save(worker);
    }

    @Override
    public void updateWorker(WorkerDto workerDetails) {
        Worker worker = workerRepository.findById(workerDetails.id).orElseThrow(() -> new RuntimeException("No existe ningún trabajador con la ID " + workerDetails.id));
        if (workerDetails.name != null) worker.setName(workerDetails.name);
        Store store = storeRepository.findById(workerDetails.store.id).orElseThrow();
        if (workerDetails.store != null) worker.setStore(store);
        if (workerDetails.orderList != null) worker.setOrderList(Assembler.toOrderList(workerDetails.orderList));
    }

    @Override
    public List<WorkerDto> getAllWorkers() {
        return workerRepository.findAll().stream().map(Assembler::toWorkerDto).toList();
    }

    @Override
    public WorkerDto getWorkerById(String workerId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("No existe ningún trabajador con la ID " + workerId));
        return Assembler.toWorkerDto(worker);
    }

    @Override
    public void assignWorkerToOrder(String workerId, String orderId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("No existe ningún trabajador con la ID " + workerId));
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID " + orderId));
        ;
        order.getWorkerList().add(worker);
        worker.getOrderList().add(order);
    }

    @Override
    public void deleteWorker(String workerId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("No existe ningún trabajador con la ID " + workerId));
        workerRepository.delete(worker);
    }
}
