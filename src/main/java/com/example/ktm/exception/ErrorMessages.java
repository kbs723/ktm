package com.example.ktm.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.MessageFormat;
import java.util.Map;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "")
public class ErrorMessages {

    // Map<Category, Map<Code, MessageTemplate with params...>>
    private Map<String, Map<String, String>> errors;

    public String getMessage(String category, int code, Object... params) {
        Map<String, String> categoryMap = errors.get(category);
        if (categoryMap == null){
            return "Unknown error";
        }

        String template = categoryMap.get(String.valueOf(code));
        if (template == null) return "Unknown error";

        return MessageFormat.format(template, params);
    }
}
