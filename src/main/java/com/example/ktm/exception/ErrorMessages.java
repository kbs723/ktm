package com.example.ktm.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "")
public class ErrorMessages {

    // Map<Category, Map<Code, MessageTemplate with params...>>
    private Map<String, Map<String, String>> errors;

    public String getMessage(String category, int code, Object... params) {
        String template = Optional.ofNullable(errors.get(category))
                .map(map -> map.get(String.valueOf(code)))
                .orElse(null);

        return template == null ? "An internal error !" : MessageFormat.format(template, params);
    }
}
