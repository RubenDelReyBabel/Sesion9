package com.babelgroup.service;

import com.babelgroup.model.Order;
import com.babelgroup.model.Worker;
import com.babelgroup.repository.WorkerRepository;
import com.babelgroup.repository.OrderRepository;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final OrderRepository orderRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository, OrderRepository orderRepository) {
        this.workerRepository = workerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Worker createWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker updateWorker(String workerId, Worker workerDetails) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(()-> new RuntimeException("No existe ningún trabajador con la ID " + workerId));
        if (workerDetails.getName() != null) worker.setName(workerDetails.getName());
        if (workerDetails.getStore() != null) worker.setStore(workerDetails.getStore());
        if (workerDetails.getOrderList() != null) worker.setOrderList(workerDetails.getOrderList());
        return workerRepository.save(worker);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getWorkerById(String workerId) {
        return workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("No existe ningún trabajador con la ID " + workerId));
    }

    @Override
    public void assignWorkerToOrder(String workerId, String orderId) {
        Worker worker = getWorkerById(workerId);
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID " + orderId));
        order.getWorkerList().add(worker);
        worker.getOrderList().add(order);
        workerRepository.save(worker);
        orderRepository.save(order);
    }

    @Override
    public void deleteWorker(String workerId) {
        Worker worker = getWorkerById(workerId);
        workerRepository.delete(worker);
    }
}
