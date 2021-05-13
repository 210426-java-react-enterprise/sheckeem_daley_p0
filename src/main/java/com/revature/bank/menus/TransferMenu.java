package com.revature.bank.menus;

public class TransferMenu extends Menu {
    String route = "/transfer";

    @Override
    public String display() {
        System.out.println("\n" + logo + "Transfer Money: ");
        return screenAddress;
    }

    @Override
    public String getRoute() {
        return route;
    }
}