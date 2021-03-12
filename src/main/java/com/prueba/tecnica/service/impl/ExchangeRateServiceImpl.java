package com.prueba.tecnica.service.impl;


import com.prueba.tecnica.model.*;
import com.prueba.tecnica.model.entity.ExchangeRate;
import com.prueba.tecnica.repository.ExchangeRateRepository;
import com.prueba.tecnica.service.ExchangeRateService;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public Single<ExchangeRateResponse> getExchangeRate(ExchangeRateRequest exchangeRateRequest) {
        return Single.just(exchangeRateRepository.
                    findByCurrencyFromAndCurrencyTo(exchangeRateRequest.getCurrency(), exchangeRateRequest.getCurrencyToExchange()))
                .map(exchangeRateFromDatabase -> calculateAndBuildResponse(exchangeRateRequest, exchangeRateFromDatabase));
    }

    @Override
    public Single<ExchangeRate> getUpdatedRate(String currencyFrom, String currencyTo, BigDecimal value) {
        return Single.just(exchangeRateRepository
                .findByCurrencyFromAndCurrencyTo(currencyFrom, currencyTo))
                .map(rate -> {
                    rate.setValue(value);
                    return exchangeRateRepository.save(rate);
                });
    }

    @Override
    public Single<List<RateResponse>> getExchangeRates() {
        return Observable.fromIterable(exchangeRateRepository.findAll())
                .map(rate -> RateResponse.builder()
                        .currencyFrom(rate.getCurrencyFrom())
                        .currencyTo(rate.getCurrencyTo())
                        .value(rate.getValue())
                        .build())
                .toList();
    }

    @Override
    public void startDatabase() {
        exchangeRateRepository.saveAll(buildExchangeRateEntity());
    }

    private List<ExchangeRate> buildExchangeRateEntity() {
        return Arrays.asList(
                ExchangeRate.builder()
                    .currencyFrom("PEN")
                    .currencyTo("USD")
                    .value(new BigDecimal("0.27"))
                    .build(),
                ExchangeRate.builder()
                    .currencyFrom("USD")
                    .currencyTo("PEN")
                    .value(new BigDecimal("3.69"))
                    .build());
    }

    private ExchangeRateResponse calculateAndBuildResponse(ExchangeRateRequest exchangeRateRequest, ExchangeRate exchangeRate) {
        return ExchangeRateResponse
                .builder()
                .original(Amount.builder()
                        .amount(exchangeRateRequest.getAmount())
                        .currency(exchangeRateRequest.getCurrency())
                        .build())
                .converted(Amount.builder()
                        .amount(exchangeRateRequest.getAmount().multiply(exchangeRate.getValue()))
                        .currency(exchangeRateRequest.getCurrencyToExchange())
                        .build())
                .build();
    }

}
