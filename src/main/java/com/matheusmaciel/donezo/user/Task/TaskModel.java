package com.matheusmaciel.donezo.user.Task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_tasks")
@Data
public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(length = 50, nullable = false)
  private String title;
  @Column(length = 244, nullable = false)
  private String description;

  
  private LocalDateTime startAt;
  private LocalDateTime endAt;

  private String priority;

  @CreationTimestamp
  private LocalDateTime createdAt;

  private UUID userId;

}
