package com.example.ktm.dto;

import com.example.ktm.markerInterface.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserDto {

    @JsonView({Views.Create.class, Views.Update.class, Views.Response.class})
    @NotBlank
    private String name;

    @JsonView({Views.Create.class, Views.Update.class})
    @NotBlank
    private String username;

    @JsonView({Views.Create.class})
    @NotBlank
    private String password;

}
