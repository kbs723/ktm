package com.example.ktm.config;

import com.example.ktm.enummisc.Types;

public class DataSourceContextHolder {

    // ThreadLocal means each HTTP request thread has its own isolated slot
    private static final ThreadLocal<Types.DataSourceType> context = new ThreadLocal<>();

    public static void set(Types.DataSourceType type) {
        context.set(type);
    }

    public static Types.DataSourceType get() {
        return context.get();
    }

    public static void clear() {
        context.remove();
    }
}
