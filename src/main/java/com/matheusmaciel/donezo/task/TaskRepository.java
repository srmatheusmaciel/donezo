package com.matheusmaciel.donezo.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, UUID> {

}
