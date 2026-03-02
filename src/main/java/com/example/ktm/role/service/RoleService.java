package com.example.ktm.role.service;

import com.example.ktm.common.mapper.BaseEntityMapper;
import com.example.ktm.common.service.BaseEntityService;
import com.example.ktm.opsunit.dto.OpsUnitDto;
import com.example.ktm.opsunit.entity.OpsUnit;
import com.example.ktm.role.dto.RoleDto;
import com.example.ktm.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseEntityService<Role, RoleDto, Long> {

    protected RoleService(JpaRepository<Role, Long> repository, BaseEntityMapper<Role, RoleDto> mapper) {
        super(repository, mapper);
    }
}
