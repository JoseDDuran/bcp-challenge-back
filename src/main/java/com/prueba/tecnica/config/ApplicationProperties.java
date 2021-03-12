package com.prueba.tecnica.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationProperties {

    @Value("${app.constants.secret-key}")
    private String secretKey;

    @Value("${app.constants.token-response-format}")
    private String tokenResponseFormat;
}
