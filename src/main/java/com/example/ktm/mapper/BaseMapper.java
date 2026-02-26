package com.example.ktm.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

public interface BaseMapper<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

    List<D> toDtoList(List<E> list);

    Set<D> toDtoSet(Set<E> set);

    void updateEntityFromDto(D dto, @MappingTarget E entity);
}