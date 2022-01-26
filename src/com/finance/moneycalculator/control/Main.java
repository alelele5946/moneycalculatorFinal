package com.finance.moneycalculator.control;

import com.finance.moneycalculator.persistence.*;

public class Main {

    public static void main(String[] args) {


        CurrencyLoader currencyLoader = new FileCurrencyLoader("currencies");   /* cargamos los datos de currencies*/
        RestExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();/*n aqui lo mismo pero con exchangerate*/
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());  /*cargamos la interface*/
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }









}
