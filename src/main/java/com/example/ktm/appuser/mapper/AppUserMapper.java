package com.example.ktm.appuser.mapper;

import com.example.ktm.common.config.BaseMapperConfig;
import com.example.ktm.common.mapper.BaseEntityMapper;
import com.example.ktm.appuser.dto.AppUserDto;
import com.example.ktm.appuser.entity.AppUser;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface AppUserMapper extends BaseEntityMapper<AppUser, AppUserDto> {

    @Override
    void map(AppUserDto dto, AppUser entity);
}