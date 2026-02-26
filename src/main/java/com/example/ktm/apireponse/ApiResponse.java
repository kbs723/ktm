package com.example.ktm.apireponse;

import com.example.ktm.enums.Types;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiResponse {

    private String msg;
    private Object data;
    private Types.ResponseType type;
}
