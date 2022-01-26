package com.finance.moneycalculator.persistence;

import com.finance.moneycalculator.model.Currency;
import com.finance.moneycalculator.model.ExchangeRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class RestExchangeRateLoader implements ExchangeRateLoader{
    @Override
    public ExchangeRate load(Currency from, Currency to)  {
        return new ExchangeRate(from, to, read(read(from.getCode(), to.getCode())) );


    }

    private String read(String from, String to)  {
        URL url = null;
        try{
            url= new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies" + from.toLowerCase() + "/" + to.toLowerCase() + ".json");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in =null;
        String line = null;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = in.readLine()) != null) {
                if (line.contains(to.toLowerCase())) break;
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return line;



    }

    private Double read(String line)  {
        return Double.parseDouble(line.split(": ")[1]);

    }
}
