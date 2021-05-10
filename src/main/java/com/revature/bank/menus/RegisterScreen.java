package com.revature.bank.menus;

public class RegisterScreen extends Menu {
    String route = "/register";

    @Override
    public boolean display() {
        System.out.println(logo + "New User Registration: \n\n");

        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}