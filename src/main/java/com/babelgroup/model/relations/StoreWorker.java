package com.babelgroup.model.relations;

import com.babelgroup.model.Store;
import com.babelgroup.model.Worker;

public class StoreWorker {

    public static void link(Store store, Worker worker) {
        store.getWorkerList().add(worker);
        worker.setStore(store);
    }

    public static void unlink(Store store, Worker worker) {
        store.getWorkerList().remove(worker);
        worker.setStore(null);
    }
}
