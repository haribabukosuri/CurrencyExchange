package com.currency.exchange.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExchangeRateNotFoundException extends RuntimeException{
    private String message;
    private String fromCurrency;
    private String toCurrency;
    private LocalDateTime localDate;
}
