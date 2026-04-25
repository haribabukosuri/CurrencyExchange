package com.currency.exchange.controller;

import com.currency.exchange.model.ExchangeRate;
import com.currency.exchange.service.ExchangeRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/CurrencyExchange")
public class ExchangeRateController {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateController.class);

    @Autowired
    private ExchangeRateService exchangeRateService;


    @GetMapping("/from/{fromCurrency}/to/{toCurrency}")
    public ResponseEntity<ExchangeRate> getExchangeRate(@PathVariable String fromCurrency, @PathVariable String toCurrency){
        logger.info("getExchangeRate from {} to {}", fromCurrency, toCurrency);
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        return ResponseEntity.ok(exchangeRate);
    }

    @PostMapping("/add")
    public ResponseEntity<ExchangeRate> createExchangeRate(@RequestBody ExchangeRate exchangeRateRequest){
        ExchangeRate exchangeRateAdded = new ExchangeRate();
        exchangeRateAdded.setFromCurrency(exchangeRateRequest.getFromCurrency());
        exchangeRateAdded.setToCurrency(exchangeRateRequest.getToCurrency());
        exchangeRateAdded.setExchangeRate(exchangeRateRequest.getExchangeRate());
        ExchangeRate exchangeRateReturned = exchangeRateService.addExchangeRate(exchangeRateAdded);
        return ResponseEntity.ok(exchangeRateReturned);
    }
}
