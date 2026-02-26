package com.example.ktm.service;

import com.example.ktm.entity.AppUser;
import com.example.ktm.repo.AppUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService extends BaseEntityService<AppUser, Long> {

    private final AppUserRepository repository;

    protected AppUserService(JpaRepository<AppUser, Long> repository, AppUserRepository appUserRepository) {
        super(repository);
        this.repository = appUserRepository;
    }

    public AppUser create(AppUser user) {
        return super.create(user);
    }

    public AppUser update(long id, AppUser user) {
        return super.update(id, user);
    }

    public void deleteById(long id) {
        super.deleteById(id);
    }

    public List<AppUser> findAll() {
        return super.findAll();
    }

    public AppUser findById(long id) {
        return super.findById(id);
    }
}
