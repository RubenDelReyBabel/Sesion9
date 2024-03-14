package com.babelgroup.service;

import com.babelgroup.model.Worker;

import java.util.List;

public interface WorkerService {
    Worker createWorker(Worker worker);
    Worker updateWorker(String workerId, Worker workerDetails);
    List<Worker> getAllWorkers();
    Worker getWorkerById(String workerId);
    void assignWorkerToOrder(String workerId, String orderId);
    void deleteWorker(String workerId);
}
