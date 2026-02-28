package com.example.ktm.appuser.dto;

import com.example.ktm.common.dto.BaseEntityDto;
import com.example.ktm.fetchview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class AppUserDto extends BaseEntityDto {

    @JsonView({Views.Create.class, Views.Update.class, Views.Response.class})
    @NotBlank
    private String name;

    @JsonView({Views.Create.class, Views.Update.class})
    @NotBlank
    private String username;

    @JsonView({Views.Create.class})
    @NotBlank
    private String password;

    @JsonView({Views.Update.class})
    @NotBlank
    private String oldPassword;
}

