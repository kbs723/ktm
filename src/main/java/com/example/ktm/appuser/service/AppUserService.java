package com.example.ktm.appuser.service;

import com.example.ktm.common.service.BaseEntityService;
import com.example.ktm.appuser.dto.AppUserDto;
import com.example.ktm.appuser.entity.AppUser;
import com.example.ktm.exception.AppException;
import com.example.ktm.appuser.mapper.AppUserMapper;
import com.example.ktm.appuser.repo.AppUserRepo;
import com.example.ktm.util.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
public class AppUserService extends BaseEntityService<AppUser, AppUserDto, Long> {

    protected AppUserService(AppUserRepo repository, AppUserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected void validateEntity(AppUser existing, AppUser incoming) {
        if(!PasswordUtil.match(incoming.getPassword(), existing.getPassword())){
            throw new AppException(1003, "user");
        }
        super.validateEntity(existing, incoming);
    }

    @Override
    protected void preCreate(AppUser incoming) {
        // encrypt password manually
        incoming.setPassword(PasswordUtil.encode(incoming.getPassword()));
    }

    @Override
    protected void preUpdate(AppUser existing, AppUser incoming) {
        existing.setName(incoming.getName());
        existing.setUsername(incoming.getUsername());
        existing.setPassword(PasswordUtil.encode(incoming.getPassword()));
    }
}
