package com.example.ktm.role.repo;

import com.example.ktm.opsunit.entity.OpsUnit;
import com.example.ktm.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
