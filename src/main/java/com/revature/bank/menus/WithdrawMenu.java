package com.revature.bank.menus;

public class WithdrawMenu extends Menu {
    String route = "/withdraw";

    @Override
    public boolean display() {
        System.out.println("\n" + logo+ "Withdrawal Menu: ");return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}