package com.revature.bank.menus;

import com.revature.bank.connections.daos.AccountDao;
import com.revature.bank.connections.daos.UserDao;
import com.revature.bank.entities.Accounts;
import com.revature.bank.entities.AppUser;

public class DepositMenu extends Menu {
    Accounts account = null;
    String route = "/deposit";
    String menuOptions = "Deposit Menu: ";

    public DepositMenu(){}

    @Override
    public String display() {
        System.out.println("\n" + logo + menuOptions);
        if (account != null) System.out.printf("Your current balance is %.2f%n \n", account.getCurrentBalance());
        else {
            account = new Accounts();
            account.create();
            AccountDao.getInstance().createAccount(UserDao.getInstance().getUser());
        }
        return screenAddress;
    }

    @Override
    public String getRoute() {
        return route;
    }
}