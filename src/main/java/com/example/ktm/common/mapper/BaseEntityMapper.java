package com.example.ktm.common.mapper;

import com.example.ktm.common.entity.BaseEntity;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

public interface BaseEntityMapper<E extends BaseEntity, D> {

    E toEntity(D dto);

    D toDto(E entity);

    List<D> toDtoList(List<E> list);

    Set<D> toDtoSet(Set<E> set);

    void map(D dto, @MappingTarget E entity);
}