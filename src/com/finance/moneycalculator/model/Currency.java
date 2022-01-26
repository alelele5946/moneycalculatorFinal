package com.finance.moneycalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Currency {
    private final String code;
    private final String name;
    private final String symbol;

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean matches(String str) {  /*devuelve si son o no iguales a uno de los tres*/
        return code.equalsIgnoreCase(str) || name.equalsIgnoreCase(str) || symbol.equals(str);
    }

    @Override
    public String toString() {
        return code;
    }
}
