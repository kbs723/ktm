package com.example.ktm.exception;

import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

@Getter
public class AppException extends RuntimeException {

    private final int code;
    private final String category;
    private final Object[] params;

    // Constructor: first string is category, remaining are message params
    // Ex: new AppException(1001, "internal")
    public AppException(int code, String... args) {
        super();
        if (ObjectUtils.isEmpty(args)) {
            throw new IllegalArgumentException("Category must be provided as first argument");
        }

        this.code = code;
        // first string is category others are params
        this.category = args[0];
        this.params = args.length > 1
                ? Arrays.copyOfRange(args, 1, args.length)
                : new Object[0];
    }
}
