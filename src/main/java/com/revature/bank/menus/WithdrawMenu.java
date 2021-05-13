package com.revature.bank.menus;

public class WithdrawMenu extends Menu {
    String route = "/withdraw";

    @Override
    public String display() {
        System.out.println("\n" + logo+ "Withdrawal Menu: ");
        return screenAddress;
    }

    @Override
    public String getRoute() {
        return route;
    }
}