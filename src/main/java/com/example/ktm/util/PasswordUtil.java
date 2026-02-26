package com.example.ktm.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

    private static PasswordEncoder encode;

    public PasswordUtil(PasswordEncoder passwordEncoder) {
        PasswordUtil.encode = passwordEncoder;
    }

    public static String encode(String password) {
        return encode.encode(password);
    }
}
