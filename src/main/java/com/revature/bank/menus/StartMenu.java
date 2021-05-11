package com.revature.bank.menus;

import com.revature.bank.MainActivity;

public class StartMenu extends Menu {
    String route = "/start";

    @Override
    public boolean display() {

        System.out.print("\n" + logo + "What would you like to do today?" +
                "A. Register a New User\n" +
                "B. Login to an Existing User\n" +
                "X. Exit Application\n" +
                "\n\n" +
                "Please Select an Option: ");
        String tempInput;
        do {
            tempInput = MainActivity.scan.next();
        } while (tempInput == null || tempInput.trim() == null);

        input = tempInput.toUpperCase().charAt(0);

        switch (input) {
            case 'A':
                ScreenRouter.getInstance().navigate("/register");
                break;
            case 'B':
                if (ScreenRouter.getInstance().navigate("/login")){
                    ScreenRouter.getInstance().navigate("/main");
                    return true;
                }
                break;
            case 'X':
                System.out.println("Logging out!");
                return false;
            default:
                System.out.println("Invalid entry, logging out!");
                return false;
        }
        return true;
    }

    @Override
    public String getRoute() {
        return route;
    }
}