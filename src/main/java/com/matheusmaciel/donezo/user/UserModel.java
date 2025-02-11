package com.matheusmaciel.donezo.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Data;

@Entity(name = "tb_users")
@Data
public class UserModel {
  
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;


  private String username;
  private String password;
  private String name;

  @CreationTimestamp
  private LocalDateTime createdAt;



}
