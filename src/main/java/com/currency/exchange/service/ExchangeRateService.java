package com.currency.exchange.service;

import com.currency.exchange.exceptions.ExchangeRateNotFoundException;
import com.currency.exchange.model.ExchangeRate;
import com.currency.exchange.repo.ExchangeRateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepo exchangeRateRepo;

    public ExchangeRate getExchangeRate(String fromCurrency, String toCurrency){
        ExchangeRate exchangeRate = exchangeRateRepo.findExchangeRateByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
        if(exchangeRate==null){
            throw new ExchangeRateNotFoundException("No Exchange Rate found.",fromCurrency,toCurrency, LocalDateTime.now());
        }
        return exchangeRateRepo.findExchangeRateByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
    }

    public ExchangeRate addExchangeRate(ExchangeRate exchangeRate){
        return exchangeRateRepo.save(exchangeRate);
    }
}
