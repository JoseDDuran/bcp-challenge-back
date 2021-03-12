package com.prueba.tecnica.service;

import com.prueba.tecnica.model.*;
import com.prueba.tecnica.model.entity.ExchangeRate;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.math.BigDecimal;
import java.util.List;

public interface ExchangeRateService {

    Single<ExchangeRateResponse> getExchangeRate(ExchangeRateRequest exchangeRateRequest);
    Single<ExchangeRate> getUpdatedRate(String currencyFrom, String currencyTo, BigDecimal value);
    Single<List<RateResponse>> getExchangeRates();
    void startDatabase();
}

