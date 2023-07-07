package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
@Entity
@Table(name = "Contact")
@lombok.Data
public class Contact {
    @Id
    @GeneratedValue
    private int id;
    private String phoneNumber;
    private String email;
    private Integer linkedId;
    private String linkPrecedence;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
