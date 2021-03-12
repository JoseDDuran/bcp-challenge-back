package com.prueba.tecnica.config;

import com.prueba.tecnica.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DatabaseBean {

    private final ExchangeRateService exchangeRateService;

    @Bean
    public void initDatabase(){
        exchangeRateService.startDatabase();
    }

}
