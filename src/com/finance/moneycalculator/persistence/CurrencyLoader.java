package com.finance.moneycalculator.persistence;

import com.finance.moneycalculator.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    Currency[] currencies();
}
