package com.example.ktm.rolemap.repo;

import com.example.ktm.rolemap.entity.RoleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapRepo extends JpaRepository<RoleMap, Long> {

}
