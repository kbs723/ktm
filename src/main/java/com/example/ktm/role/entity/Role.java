package com.example.ktm.role.entity;

import com.example.ktm.common.entity.BaseEntity;
import com.example.ktm.enummisc.Permissions;
import com.example.ktm.opsunit.entity.OpsUnit;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Role extends OpsUnit {

    @NotBlank
    private String name;

    private Boolean isPrimary;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id")
    )

    @Column(name = "permission")
    private Set<Permissions> permissions;
}
