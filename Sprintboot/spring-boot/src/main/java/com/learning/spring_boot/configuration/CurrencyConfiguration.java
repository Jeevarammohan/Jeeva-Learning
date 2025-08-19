package com.learning.spring_boot.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency-service")
@Component
@Data
public class CurrencyConfiguration {
    private String url;
    private String username;
    private String key;
}
