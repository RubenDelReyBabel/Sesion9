package com.babelgroup.service.worker;

import com.babelgroup.dtos.WorkerDto;
import com.babelgroup.model.Order;
import com.babelgroup.model.Worker;
import com.babelgroup.repository.WorkerRepository;
import com.babelgroup.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final OrderRepository orderRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository, OrderRepository orderRepository) {
        this.workerRepository = workerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void createWorker(WorkerDto workerDetails) {
        Worker worker = new Worker();
        worker.setName(workerDetails.getName());
        worker.setSurname(workerDetails.getSurname());
        worker.setMonthlySalary(workerDetails.getMonthlySalary());
        worker.setStore(workerDetails.getStore());
        worker.setOrderList(workerDetails.getOrderList());
        workerRepository.save(worker);
    }

    @Override
    public void updateWorker(WorkerDto workerDetails) {
        Worker worker = workerRepository.findById(workerDetails.getId()).orElseThrow(()-> new RuntimeException("No existe ningún trabajador con la ID " + workerDetails.getId()));
        if (workerDetails.getName() != null) worker.setName(workerDetails.getName());
        if (workerDetails.getStore() != null) worker.setStore(workerDetails.getStore());
        if (workerDetails.getOrderList() != null) worker.setOrderList(workerDetails.getOrderList());
    }

    @Override
    public List<WorkerDto> getAllWorkers() {
        return workerRepository.findAll().stream().map(worker -> new WorkerDto(worker.getId(), worker.getName(), worker.getSurname(), worker.getMonthlySalary(), worker.getStore(), worker.getOrderList())).collect(Collectors.toList());
    }

    @Override
    public WorkerDto getWorkerById(String workerId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("No existe ningún trabajador con la ID " + workerId));
        return new WorkerDto(worker.getId(), worker.getName(), worker.getSurname(), worker.getMonthlySalary(), worker.getStore(), worker.getOrderList());
    }

    @Override
    public void assignWorkerToOrder(String workerId, String orderId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("No existe ningún trabajador con la ID " + workerId));
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No existe ninguna orden con la ID " + orderId));;
        order.getWorkerList().add(worker);
        worker.getOrderList().add(order);
    }

    @Override
    public void deleteWorker(String workerId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("No existe ningún trabajador con la ID " + workerId));
        workerRepository.delete(worker);
    }
}
