package com.example.ktm.rolemap.dto;

import com.example.ktm.appuser.entity.AppUser;
import com.example.ktm.common.dto.BaseEntityDto;
import com.example.ktm.enummisc.Permissions;
import com.example.ktm.role.entity.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleMapDto extends BaseEntityDto {

    @NotNull
    private AppUser appUser;

    @NotNull
    private Role role;
}
