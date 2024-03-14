package com.babelgroup.repository;

import com.babelgroup.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository  extends JpaRepository<Worker, String> {
}
