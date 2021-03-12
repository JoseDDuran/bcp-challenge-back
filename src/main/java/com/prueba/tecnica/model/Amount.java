package com.prueba.tecnica.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class Amount {
    private BigDecimal amount;
    private String currency;
}
