package com.example.ktm.apireponse;

import com.example.ktm.enums.Types;
import com.example.ktm.fetchview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiResponse {

    @JsonView({Views.Create.class, Views.Update.class, Views.Response.class})
    private String msg;

    @JsonView({Views.Create.class, Views.Update.class, Views.Response.class})
    private Object data;

    @JsonView({Views.Create.class, Views.Update.class, Views.Response.class})
    private Types.ResponseType type;
}
