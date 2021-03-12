package com.prueba.tecnica.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "EXCHANGE_RATE")
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CURRENCY_FROM")
    private String currencyFrom;

    @Column(name = "CURRENCY_TO")
    private String currencyTo;

    @Column(name = "VALUE")
    private BigDecimal value;
}
