package com.example.ktm.common.service;

import java.util.List;
import com.example.ktm.common.entity.BaseEntity;
import com.example.ktm.common.mapper.BaseEntityMapper;
import com.example.ktm.exception.AppException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseEntityService<E extends BaseEntity, D, ID>{

    protected final JpaRepository<E, ID> repository;
    protected final BaseEntityMapper<E, D> mapper;

    protected BaseEntityService(
            JpaRepository<E, ID> repository,
            BaseEntityMapper<E, D> mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    /* ---------  For entity's ---------- */
    @Transactional
    public E create(E entity) {
        isNotNull(entity);
        preCreate(entity);
        return repository.save(entity);
    }

    @Transactional
    public E update(E entity) {
        isNotNull(entity);
        validateEntity(null, entity);
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public E findById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new AppException(1004, "entity"));
    }

    @Transactional(readOnly = true)
    public List<E> findAll() {
        return repository.findAll();
    }

    protected void isNotNull(E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
    }

    protected void validateEntity(E existing, E incoming) {}

    protected void preCreate(E incoming) {}

    protected void preUpdate(E existing, E incoming) {}

    /* ---------  For dto's ---------- */
    @Transactional
    public D createDto(D dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDto(create(entity));
    }

    @Transactional
    public D updateDto(ID id, D dto) {
        E existing = findById(id);
        mapper.map(dto, existing);
        preUpdate(existing, existing);
        return mapper.toDto(update(existing));
    }

    public D findDtoById(ID id) {
        return mapper.toDto(findById(id));
    }

    public List<D> findAllDto() {
        return findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}