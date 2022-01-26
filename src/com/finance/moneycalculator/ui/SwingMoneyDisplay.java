package com.finance.moneycalculator.ui;

import com.finance.moneycalculator.model.Money;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private Money money;

    @Override
    public void show(Money money) {
        this.money = money;
        this.removeAll();
        this.add(amount());
        this.add(currency());
        this.updateUI();

    }

    private Component amount() {
        return new JLabel(String.valueOf(money.getAmount()));
    }

    private Component currency() {
        return new JLabel(String.valueOf(money.getCurrency().getCode()));
    }


}
