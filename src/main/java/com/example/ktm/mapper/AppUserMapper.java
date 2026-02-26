package com.example.ktm.mapper;

import com.example.ktm.dto.AppUserDto;
import com.example.ktm.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AppUserMapper extends BaseMapper<AppUser, AppUserDto> {

    @Override
    AppUser toEntity(AppUserDto dto);

    @Override
    @Mapping(target = AppUser.Fields.password, ignore = true)
    AppUserDto toDto(AppUser entity);

    @Override
    @Mapping(target = AppUser.Fields.password, ignore = true)
    List<AppUserDto> toDtoList(List<AppUser> list);

    @Override
    @Mapping(target = AppUser.Fields.password, ignore = true)
    Set<AppUserDto> toDtoSet(Set<AppUser> set);

    @Override
    @Mapping(target = AppUser.Fields.password, ignore = true)
    void updateEntityFromDto(AppUserDto dto, @MappingTarget AppUser entity);
}