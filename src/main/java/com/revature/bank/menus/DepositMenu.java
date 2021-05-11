package com.revature.bank.menus;

public class DepositMenu extends Menu {
    String route = "/deposit";

    @Override
    public boolean display() {
        System.out.println("\n" + logo + "Deposit Menu: ");
        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}