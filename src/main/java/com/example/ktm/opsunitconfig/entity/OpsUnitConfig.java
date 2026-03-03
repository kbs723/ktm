package com.example.ktm.opsunitconfig.entity;

import com.example.ktm.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OpsUnitConfig extends BaseEntity {

    @NotNull
    private String opsUnitCode;

    private String primaryUrl;
    private String primaryUsername;
    private String primaryPassword;

    private String replicaUrl;
    private String replicaUsername;
    private String replicaPassword;
}
