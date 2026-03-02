package com.example.ktm.common.service;

import java.util.List;
import com.example.ktm.common.entity.BaseEntity;
import com.example.ktm.common.mapper.BaseEntityMapper;
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
    public E create(E entity) {
        isNotNull(entity);
        return repository.save(entity);
    }

    public E update(E entity) {
        isNotNull(entity);
//        E existing = findById(entity);
        validateEntity(null, entity);
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public E findById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
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

    protected void validateEntity(E existing, E incoming) {
        if (incoming == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
    }

    protected void preCreate(E incoming) {}

    protected void preUpdate(E existing, E incoming) {}

    /* ---------  For dto's ---------- */
    public D createDto(D dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDto(create(entity));
    }

    @Transactional(readOnly = true)
    public D updateDto(ID id, D dto) {
        E existing = findById(id);

        // Update existing entity fields
        mapper.map(dto, existing);

        return mapper.toDto(update(existing));
    }

    @Transactional(readOnly = true)
    public D findDtoById(ID id) {
        return mapper.toDto(findById(id));
    }

    public List<D> findAllDto() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}