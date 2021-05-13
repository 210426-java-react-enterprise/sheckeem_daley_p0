package com.revature.bank.entities;

import com.revature.bank.MainActivity;
import com.revature.bank.connections.daos.AccountDao;
import com.revature.bank.connections.daos.TransactionDao;
import com.revature.bank.connections.daos.UserDao;

public class Accounts {
    private AppUser client;
    private int id;
    private int clientId;
    private Double currentBalance = 0.0;
    private int type;
    private boolean isActive = true;
    private boolean isLocked = false;
    private boolean isAdminLocked = false;

    public Accounts(){
        client = UserDao.getInstance().getUser();
        clientId = client.getId();
    }

    //CREATE ACCOUNT
    public void create() {

        System.out.println("Account Creation:");
        System.out.print("Starting Balance: ");
        AccountDao.getInstance().findAcountFromDb(UserDao.getInstance().getUser());
        deposit(MainActivity.scan.nextDouble());
        System.out.println("Account Successfully Created!");
    }

    //MATH
    public double withdraw(double amount) {
        amount = Math.abs(amount);
        if (amount > currentBalance) {
            System.out.println("Your balance is insufficient to make this withdrawal!");
        } else currentBalance -= amount;
        return currentBalance;
    }

    public double deposit(double amount) {
        amount = Math.abs(amount);
        currentBalance += amount;
        System.out.printf("You've just added +$%.2f to your account." +
                "Your new balance is $%.2f", amount, currentBalance);
        AccountDao.getInstance().findAcountFromDb(UserDao.getInstance().getUser());
        return currentBalance;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public int getType() {
        return type;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean isAdminLocked() {
        return isAdminLocked;
    }

    //SETTERS
    public void setAdminLocked(boolean adminLocked) {
        isAdminLocked = adminLocked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setType(int typeId) {
        this.type = typeId;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}