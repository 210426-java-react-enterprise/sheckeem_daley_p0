package com.revature.bank.menus;

public class TransactionsMenu extends Menu {
    String route = "/transactions";

    @Override
    public String display() {
        System.out.println("\n" + logo + "Transactions Menu: ");
        return screenAddress;
    }

    @Override
    public String getRoute() {
        return route;
    }
}
