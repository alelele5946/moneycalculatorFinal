package com.finance.moneycalculator.persistence;

import com.finance.moneycalculator.model.Currency;
import com.finance.moneycalculator.model.ExchangeRate;

import java.io.IOException;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to) ;
}
