package com.revature.bank.menus;

public class AccountsMenu extends Menu {
    String route = "/accounts";

    @Override
    protected boolean display() {
        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}
