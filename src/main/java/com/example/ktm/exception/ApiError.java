package com.example.ktm.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiError {

    private int code;
    private String error;
    private String message;
    private String category;
}
