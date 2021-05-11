package com.revature.bank.menus;

public class TransactionsMenu extends Menu {
    String route = "/transactions";

    @Override
    protected boolean display() {
        System.out.println("\n" + logo + "Transactions Menu: ");
        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}
