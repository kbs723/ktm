package com.example.ktm.opsunit.service;

import com.example.ktm.common.mapper.BaseEntityMapper;
import com.example.ktm.common.service.BaseEntityService;
import com.example.ktm.opsunit.dto.OpsUnitDto;
import com.example.ktm.opsunit.entity.OpsUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OpsUnitService extends BaseEntityService<OpsUnit, OpsUnitDto, Long> {

    protected OpsUnitService(JpaRepository<OpsUnit, Long> repository, BaseEntityMapper<OpsUnit, OpsUnitDto> mapper) {
        super(repository, mapper);
    }
}
