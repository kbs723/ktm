package com.example.ktm.service;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseEntityService<T, ID>{

    protected final JpaRepository<T, ID> repository;

    protected BaseEntityService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    public T update(ID id, T entity) {
        if(entity == null) { throw new IllegalArgumentException("Entity cannot be null"); }
        findById(id); // Ensure entity exists

        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
