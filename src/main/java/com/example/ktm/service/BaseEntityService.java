package com.example.ktm.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ktm.mapper.BaseMapper;

public abstract class BaseEntityService<E, D, ID>{

    protected final JpaRepository<E, ID> repository;
    protected final BaseMapper<E, D> mapper;

    protected BaseEntityService(
            JpaRepository<E, ID> repository,
            BaseMapper<E, D> mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    /* ---------  For entity's ---------- */
    public E create(E entity) {
        validateEntity(entity);
        return repository.save(entity);
    }

    public E update(E entity) {
        validateEntity(entity);
        return repository.save(entity);
    }

    public E findById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    protected void validateEntity(E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
    }

    /* ---------  For dto's ---------- */
    public D createDto(D dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDto(create(entity));
    }

    public D updateDto(ID id, D dto) {

        E existing = findById(id);

        // Update existing entity fields
        mapper.updateEntityFromDto(dto, existing);

        return mapper.toDto(update(existing));
    }

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