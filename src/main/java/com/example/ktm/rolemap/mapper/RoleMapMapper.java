package com.example.ktm.rolemap.mapper;

import com.example.ktm.rolemap.dto.RoleMapDto;
import com.example.ktm.rolemap.entity.RoleMap;
import com.example.ktm.common.config.BaseMapperConfig;
import com.example.ktm.common.mapper.BaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface RoleMapMapper extends BaseEntityMapper<RoleMap, RoleMapDto> {
}