package com.prueba.tecnica.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ExchangeRateRequest {
    private String currency;
    private String currencyToExchange;
    private BigDecimal amount;
}
