package com.revature.bank.menus;

public class TransferMenu extends Menu {
    String route = "/transfer";

    @Override
    public boolean display() {
        System.out.println("\n" + logo + "Transfer Money: ");

        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}