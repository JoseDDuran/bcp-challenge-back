package com.prueba.tecnica.repository;

import com.prueba.tecnica.model.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    ExchangeRate findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);
}
