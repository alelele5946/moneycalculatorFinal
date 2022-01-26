package com.finance.moneycalculator.control;

import com.finance.moneycalculator.model.Currency;
import com.finance.moneycalculator.ui.MoneyDialog;
import com.finance.moneycalculator.ui.MoneyDisplay;
import com.finance.moneycalculator.ui.SwingMoneyDialog;
import com.finance.moneycalculator.ui.SwingMoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private final Currency[] currencies;
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;


    public MainFrame(Currency[] currencies) {
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(),BorderLayout.NORTH);
        this.add(moneyDisplay(), BorderLayout.CENTER);
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);

    }



    public void add(Command command){
        commands.put(command.name(), command);
    }


    public MoneyDialog getMoneyDisplay() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDialog() {
        return  moneyDisplay;
    }

    private Component moneyDisplay() {

        SwingMoneyDisplay display = new SwingMoneyDisplay();
        moneyDisplay = display;

        return display;

    }

    private Component moneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog(currencies);
        moneyDialog = dialog;
        return dialog;



    }
    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(calculateButton());
        return panel;
    }

    private JButton calculateButton() {
        JButton button = new JButton("CALCULATE");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("calculate").execute();
            }
        };
    }




}
