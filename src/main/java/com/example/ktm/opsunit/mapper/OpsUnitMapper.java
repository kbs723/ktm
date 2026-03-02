package com.example.ktm.opsunit.mapper;

import com.example.ktm.common.config.BaseMapperConfig;
import com.example.ktm.common.mapper.BaseEntityMapper;
import com.example.ktm.opsunit.dto.OpsUnitDto;
import com.example.ktm.opsunit.entity.OpsUnit;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface OpsUnitMapper extends BaseEntityMapper<OpsUnit, OpsUnitDto> {
}