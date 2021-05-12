package com.revature.bank.entities;

import java.util.Date;

public class Transactions {
    private int id;
    private int accountId;
    private String type;
    private int typeId;
    private double amount;
    private Date date;
    private boolean notFlagged;

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNotFlagged(boolean notFlagged) {
        this.notFlagged = notFlagged;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getType() {
        return type;
    }

    public int getTypeId() {
        return typeId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public boolean isNotFlagged() {
        return notFlagged;
    }
}