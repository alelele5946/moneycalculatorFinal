package com.finance.moneycalculator.control;

import java.io.IOException;

public interface Command { /*se encarga de ejecutar los comandos*/
    String name();
    void execute() ;
}
