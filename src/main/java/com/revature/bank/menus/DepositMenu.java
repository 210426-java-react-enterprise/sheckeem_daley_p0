package com.revature.bank.menus;

import com.revature.bank.entities.Accounts;

public class DepositMenu extends Menu {
    Accounts account;

    String route = "/deposit";
    String menuOptions = "Deposit Menu: ";

    @Override
    public String display() {
        System.out.println("\n" + logo + menuOptions);
        if (account != null) System.out.printf("Your current balance is %.2f%n", account.getCurrentBalance());
        else {
            account = new Accounts();
            account.create();
        }
        return screenAddress;
    }

    @Override
    public String getRoute() {
        return route;
    }
}