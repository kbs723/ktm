package com.example.ktm.opsunit.repo;

import com.example.ktm.opsunit.entity.OpsUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpsUnitRepo extends JpaRepository<OpsUnit, Long> {

}
