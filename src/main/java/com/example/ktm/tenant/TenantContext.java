package com.example.ktm.tenant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TenantContext {

    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();

    // TODO: check usage and remove
    private static final ThreadLocal<Boolean> READ_ONLY = new ThreadLocal<>();

    public static void set(String tenant) {
        CURRENT_TENANT.set(tenant);
    }

    public static String get() {
        return CURRENT_TENANT.get();
    }

    public static void clear() {
        CURRENT_TENANT.remove();
        READ_ONLY.remove();
    }

    public static void setReadOnly(boolean readOnly) {
        READ_ONLY.set(readOnly);
    }

    public static boolean isReadOnly() {
        return Boolean.TRUE.equals(READ_ONLY.get());
    }
}