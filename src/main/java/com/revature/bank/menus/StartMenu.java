package com.revature.bank.menus;

import com.revature.bank.MainActivity;

public class StartMenu extends Menu {
    String route = "/start";

    @Override
    public boolean display() {

        System.out.print(logo + "What would you like to do today?\n" +
                "A. Register a New User\n" +
                "B. Login to an Existing User\n" +
                "X. Exit Application\n" +
                "\n\n" +
                "Please Select an Option: ");

        switch (input = MainActivity.scan.nextLine().toUpperCase().charAt(0)) {
            case 'A':
                ScreenRouter.getInstance().navigate("/register");
                break;
            case 'B':
                ScreenRouter.getInstance().navigate("/login");
                break;
            case 'X':
                return false;
        }
        return true;
    }

    @Override
    public String getRoute() {
        return route;
    }
}