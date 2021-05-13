package com.revature.bank.menus;


import com.revature.bank.entities.AppUser;
import com.revature.bank.MainActivity;
import com.revature.bank.connections.daos.UserDao;

public class LoginScreen extends Menu {
    String route = "/login";
    String menuOptions = "Log In to Your Accounts: ";

    String username;
    String password;
    boolean correct = false;

    @Override
    public String display() {
        AppUser user = new AppUser();
        while (correct == false) {
            System.out.println("\n" + logo + menuOptions);
            System.out.print("Please enter your username: ");
            username = MainActivity.scan.nextLine();
            System.out.print("Please enter your password: ");
            password = MainActivity.scan.nextLine();

            user = UserDao.getInstance().find(username,password);
            if (user != null) {
                correct = true;
                System.out.println("Login successful!\n");
                ScreenRouter.getInstance().navigate("/main");
            } else {
                System.out.println("LOGIN FAILED!\n");
                correct = false;
            }
        }
        return screenAddress;
    }

    public boolean login() {
        return false;
    }

    @Override
    public String getRoute() {
        return route;
    }
}