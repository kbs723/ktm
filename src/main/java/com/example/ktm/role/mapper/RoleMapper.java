package com.example.ktm.role.mapper;

import com.example.ktm.common.config.BaseMapperConfig;
import com.example.ktm.common.mapper.BaseEntityMapper;
import com.example.ktm.opsunit.dto.OpsUnitDto;
import com.example.ktm.opsunit.entity.OpsUnit;
import com.example.ktm.role.dto.RoleDto;
import com.example.ktm.role.entity.Role;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface RoleMapper extends BaseEntityMapper<Role, RoleDto> {
}