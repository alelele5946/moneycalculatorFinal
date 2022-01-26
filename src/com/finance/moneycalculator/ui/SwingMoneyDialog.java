package com.finance.moneycalculator.ui;

import com.finance.moneycalculator.control.Command;
import com.finance.moneycalculator.model.Currency;
import com.finance.moneycalculator.model.Money;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private Currency currency;
    private String amount;
    private Currency[] currencies;

    public SwingMoneyDialog(Currency[] currencies) {
        this.currencies = currencies;
        this.add(amount());
        this.add(currency());
    }

    @Override
    public Money ask() {

        return new Money(Double.parseDouble(amount),currency);
    }

    private Component amount() {
        JTextField textField = new JTextField("100");
        textField.setColumns(10);
        textField.getDocument().addDocumentListener(amountChanged());
        amount = textField.getText();

        return textField;
    }





    private Component currency() {
        JComboBox combo = new JComboBox(currencies);
        combo.addItemListener(currencyChanged());
        currency = (Currency) combo.getSelectedItem();
        return combo;
    }

    private ItemListener currencyChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.DESELECTED)return;
                currency = (Currency) e.getItem();

            }
        };
    }

    /*
    private Currency[] currencies() {
        return new Currency[] {
                new Currency("USD","Dólar USA", "$"),
                new Currency("CAD","Dólar CAD", "$"),
                new Currency("GBP","Libra esterlina", "£"),

        };
    }*/



    private DocumentListener amountChanged() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                amountChanged(e.getDocument());
            }

            private void amountChanged(Document document){
                try{
                    amount = document.getText(0,document.getLength());

                } catch (BadLocationException e) {
                }
            }
        };
    }


}
