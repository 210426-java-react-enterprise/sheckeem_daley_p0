package com.revature.bank.menus;


import com.revature.bank.MainActivity;

public class LoginScreen extends Menu {
    String route = "/login";
    String username;
    String password;

    @Override
    public boolean display() {

        System.out.println(logo + "Log In to Your Account: \n\n");
        System.out.print("Please enter your username: ");
        username = MainActivity.scan.nextLine();
        System.out.print("Please enter your password: ");
        password = MainActivity.scan.nextLine();

        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}