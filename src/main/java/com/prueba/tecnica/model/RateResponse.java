package com.prueba.tecnica.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@Builder
public class RateResponse {
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal value;
}
