package com.example.ktm.appuser.entity;

import com.example.ktm.common.entity.BaseEntity;
import com.example.ktm.rolemap.entity.RoleMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class AppUser extends BaseEntity {

    private String name;

    @Column(nullable = false)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "appUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<RoleMap> roleSet = new HashSet<>();;
}
