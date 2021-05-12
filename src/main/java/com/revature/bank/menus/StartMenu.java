package com.revature.bank.menus;

import com.revature.bank.MainActivity;
import com.revature.bank.connections.daos.UserDao;

public class StartMenu extends Menu {
    String route = "/start";

    @Override
    public boolean display() {

        System.out.print("\n" + logo + "What would you like to do today?\n" +
                "A. Register a New User\n" +
                "B. Login to an Existing User\n" +
                "X. Exit Application\n\n" +
                "Please Select an Option: ");
        String tempInput;
        do {
            tempInput = MainActivity.scan.nextLine();
        } while (tempInput == null || tempInput.trim() == null || tempInput.isEmpty());

        input = tempInput.toUpperCase().charAt(0);

        switch (input) {
            case 'A':
                ScreenRouter.getInstance().navigate("/register");
                break;
            case 'B':
                ScreenRouter.getInstance().navigate("/login");
                break;
            case 'X':
            default:
                System.out.println("Logging out!");
                MainActivity.setAppRunning(false);
                UserDao.getInstance().clearCredentials();
                return false;
        }
        return true;
    }

    @Override
    public String getRoute() {
        return route;
    }
}