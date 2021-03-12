package com.prueba.tecnica.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class ExchangeRateResponse {
    private Amount original;
    private Amount converted;
}
