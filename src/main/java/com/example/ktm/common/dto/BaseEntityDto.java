package com.example.ktm.common.dto;

import com.example.ktm.enums.Status;
import lombok.Data;

import java.time.Instant;

@Data
public class BaseEntityDto {

    private Long id;

    private Status.BaseStatus status;

    private Instant createdAt;

    private Instant updatedAt;
}
