package com.finance.moneycalculator.model;

import com.finance.moneycalculator.persistence.ExchangeRateLoader;

import java.io.IOException;

public class MoneyExchanger {
    private final ExchangeRateLoader exchangeRateLoader;

    public MoneyExchanger(ExchangeRateLoader exchangeRateLoader) {
        this.exchangeRateLoader = exchangeRateLoader;
    }

    public Money exchange(Money money, Currency currency) throws IOException {
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.getCurrency(), currency);
        return new Money(money.getAmount() * exchangeRate.getRate(), currency);
    }
}
