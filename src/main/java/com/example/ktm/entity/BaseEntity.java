package com.example.ktm.entity;

import com.example.ktm.enums.Status;
import com.example.ktm.enums.Types;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Status.BaseStatus status = Status.BaseStatus.ACTIVE;

    private Long createdAt;

    private Long updatedAt;
}
