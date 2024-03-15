package com.babelgroup.service.worker;

import com.babelgroup.dtos.WorkerDto;

import java.util.List;

public interface WorkerService {
    void createWorker(WorkerDto workerDetails);
    void updateWorker(WorkerDto workerDetails);
    List<WorkerDto> getAllWorkers();
    WorkerDto getWorkerById(String workerId);
    void assignWorkerToOrder(String workerId, String orderId);
    void deleteWorker(String workerId);
}
