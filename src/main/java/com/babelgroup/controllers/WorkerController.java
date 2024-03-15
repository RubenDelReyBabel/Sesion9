package com.babelgroup.controllers;

import com.babelgroup.dtos.WorkerDto;
import com.babelgroup.model.Store;
import com.babelgroup.service.StoreService;
import com.babelgroup.service.worker.WorkerService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class WorkerController {

    private WorkerService workerService;
    private StoreService storeService;

    @RequestMapping("/stores/{storeId}/workers/add")
    public String addProduct(Model model, @PathVariable String storeId, @Validated WorkerDto worker) {
        Store store = storeService.findById(storeId);
        worker.store = storeId;
        workerService.addWorker(worker);

        model.addAttribute("store", store);

        return "workers/manage";
    }
}
