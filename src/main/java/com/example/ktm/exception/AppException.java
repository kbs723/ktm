package com.example.ktm.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {

    private final int code;          // Custom numeric code
    private final String category;   // e.g., "user", "generic"
    private final Object[] params;   // Remaining parameters for message

    /**
     * Constructor: first string is category, remaining are message params
     * Example:
     * new AppException(1001, "user", "Barani")
     */
    public AppException(int code, String... args) {
        super(); // message will be resolved later via ErrorMessages
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Category must be provided as first argument");
        }
        this.code = code;
        this.category = args[0];  // first string is category

        if (args.length > 1) {
            this.params = new Object[args.length - 1];
            System.arraycopy(args, 1, this.params, 0, args.length - 1);
        } else {
            this.params = new Object[0];
        }
    }
}
