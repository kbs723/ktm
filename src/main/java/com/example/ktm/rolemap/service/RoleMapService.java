package com.example.ktm.rolemap.service;

import com.example.ktm.rolemap.dto.RoleMapDto;
import com.example.ktm.rolemap.entity.RoleMap;
import com.example.ktm.common.mapper.BaseEntityMapper;
import com.example.ktm.common.service.BaseEntityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleMapService extends BaseEntityService<RoleMap, RoleMapDto, Long> {

    protected RoleMapService(JpaRepository<RoleMap, Long> repository, BaseEntityMapper<RoleMap, RoleMapDto> mapper) {
        super(repository, mapper);
    }
}
