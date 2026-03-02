package com.example.ktm.opsunit.entity;

import com.example.ktm.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OpsUnit extends BaseEntity {

    @NotBlank
    private String name;

    private Boolean isPrimary;
}
