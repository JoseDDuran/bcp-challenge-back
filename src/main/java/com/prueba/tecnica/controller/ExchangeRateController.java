package com.prueba.tecnica.controller;

import com.prueba.tecnica.model.*;
import com.prueba.tecnica.model.entity.ExchangeRate;
import com.prueba.tecnica.service.ExchangeRateService;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/exchange-rate/v1")
@RestController
@AllArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @PostMapping(value = "/calculate")
    public Single<ExchangeRateResponse> saveClient(@RequestBody ExchangeRateRequest exchangeRateRequest) {
        return exchangeRateService.getExchangeRate(exchangeRateRequest);
    }

    @PatchMapping(value = "/from/{currencyFrom}/to/{currencyTo}")
    public Single<ExchangeRate> updateRate(@PathVariable String currencyFrom,
                                           @PathVariable String currencyTo,
                                           @RequestBody RateRequest rateRequest) {
        return exchangeRateService.getUpdatedRate(currencyFrom, currencyTo, rateRequest.getValue());
    }

    @GetMapping(value = "/rate")
    public Single<List<RateResponse>> saveClient() {
        return exchangeRateService.getExchangeRates();
    }
}
