package com.revature.bank.menus;

import com.revature.bank.MainActivity;
import com.revature.bank.connections.daos.UserDao;

public class StartMenu extends Menu {
    String route = "/start";
    String menuOptions = "What would you like to do today?\n" +
            "A. Register a New User\n" +
            "B. Login to an Existing User\n" +
            "X. Exit Application\n\n" +
            "Please Select an Option: ";

    @Override
    public String display() {
        String screenAddress = route;

        System.out.print("\n" + logo + menuOptions);
        String tempInput;
        do {
            tempInput = MainActivity.scan.nextLine();
        } while (tempInput == null || tempInput.trim() == null || tempInput.isEmpty());

        input = tempInput.toUpperCase();

        switch (input) {
            case "A":
                ScreenRouter.getInstance().navigate("/register");
                break;
            case "B":
                ScreenRouter.getInstance().navigate("/login");
                break;
            case "X":
            default:
                System.out.println("Logging out!");
                UserDao.getInstance().clearCredentials();
                return "/start";
        }
        return screenAddress;
    }

    @Override
    public String getRoute() {
        return route;
    }
}