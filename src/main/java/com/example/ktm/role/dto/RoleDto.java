package com.example.ktm.role.dto;

import com.example.ktm.common.dto.BaseEntityDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDto extends BaseEntityDto {

    @NotBlank
    private String name;

    private Boolean isPrimary;
}
