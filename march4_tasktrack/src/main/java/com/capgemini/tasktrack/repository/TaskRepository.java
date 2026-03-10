package com.capgemini.tasktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.tasktrack.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}