package com.example.ktm.opsunitconfig.repo;

import com.example.ktm.opsunitconfig.entity.OpsUnitConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpsUnitDbConfigRepository extends JpaRepository<OpsUnitConfig, Long> {

    List<OpsUnitConfig> findByActiveTrue();
}

