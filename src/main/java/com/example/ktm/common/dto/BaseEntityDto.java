package com.example.ktm.common.dto;

import com.example.ktm.enums.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseEntityDto {

    private Long id;

    private Status.BaseStatus status;

    private Long createdAt;

    private Long updatedAt;
}
