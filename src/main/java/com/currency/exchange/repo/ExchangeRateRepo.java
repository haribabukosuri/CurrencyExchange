package com.currency.exchange.repo;

import com.currency.exchange.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepo extends JpaRepository<ExchangeRate, Integer> {
    ExchangeRate findExchangeRateByFromCurrencyAndToCurrency(String fromCurrency, String fromCurrency1);
}
