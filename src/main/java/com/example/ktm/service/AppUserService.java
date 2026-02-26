package com.example.ktm.service;

import com.example.ktm.dto.AppUserDto;
import com.example.ktm.entity.AppUser;
import com.example.ktm.mapper.AppUserMapper;
import com.example.ktm.repo.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService extends BaseEntityService<AppUser, AppUserDto, Long> {

    private final PasswordEncoder passwordEncoder;

    protected AppUserService(AppUserRepository repository, AppUserMapper mapper,
                             PasswordEncoder passwordEncoder) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
    }

    public AppUserDto create(AppUserDto dto) {
        // encrypt password manually
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        return createDto(dto);
    }

    public AppUserDto update(long id, AppUserDto user) {
        return super.updateDto(id, user);
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
