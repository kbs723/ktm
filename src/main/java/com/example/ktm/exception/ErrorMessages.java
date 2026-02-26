package com.example.ktm.exception;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.MessageFormat;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "errors")
@Getter
public class ErrorMessages {

    // Map<Category, Map<Code, MessageTemplate>>
    private Map<String, Map<String, String>> errors;

    /**
     * Get formatted message for a given category + code + optional params
     * @param category e.g., "user" or "generic"
     * @param code e.g., "1001"
     * @param params optional parameters for placeholders {0}, {1}...
     * @return formatted message
     */
    public String getMessage(String category, String code, Object... params) {
        Map<String, String> categoryMap = errors.get(category);
        if (categoryMap == null){
            return "Unknown error";
        }

        String template = categoryMap.get(code);
        if (template == null) return "Unknown error";

        return MessageFormat.format(template, params);
    }
}
