package com.revature.bank.menus;

public class TransactionsMenu extends Menu {
    String route = "/transactions";

    @Override
    protected boolean display() {
        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}
