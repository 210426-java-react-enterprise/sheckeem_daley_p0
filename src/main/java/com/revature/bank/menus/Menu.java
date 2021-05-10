package com.revature.bank.menus;

public abstract class Menu {
    char input;

    String logo = "+-----------+        --        +\n| Bank Bank | a family company |\n+-----------+        --        +\n";

    protected abstract boolean display();

    protected abstract String getRoute();
}