package com.finance.moneycalculator.control;

import com.finance.moneycalculator.model.Currency;
import com.finance.moneycalculator.model.Money;
import com.finance.moneycalculator.persistence.ExchangeRateLoader;
import com.finance.moneycalculator.ui.MoneyDialog;
import com.finance.moneycalculator.ui.MoneyDisplay;

import java.io.IOException;


public class CalculateCommand implements Command{

    private final MoneyDisplay moneyDisplay;
    private final MoneyDialog moneyDialog;
    private final ExchangeRateLoader loader;
    private Currency eur = new Currency("EUR", "Euro", "€");

    public CalculateCommand(MoneyDisplay moneyDisplay, MoneyDialog moneyDialog, ExchangeRateLoader loader) {
        this.moneyDisplay = moneyDisplay;
        this.moneyDialog = moneyDialog;
        this.loader = loader;
    }

    @Override
    public String name() {
        return "calculate";
    }

    @Override
    public void execute() {
        moneyDisplay.show(exchange(moneyDialog.ask()));

    }

    private Money exchange(Money money)  {
        Money result;
        return new Money(money.getAmount() * rateOf(money.getCurrency()), eur);
    }
    private double rateOf(Currency currency) {
        return loader.load(currency,eur).getRate();
    }
}
