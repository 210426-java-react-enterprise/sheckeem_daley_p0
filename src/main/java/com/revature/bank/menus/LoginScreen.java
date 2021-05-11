package com.revature.bank.menus;


import com.revature.bank.users.AppUser;
import com.revature.bank.MainActivity;
import com.revature.bank.users.UserDao;

public class LoginScreen extends Menu {
    String route = "/login";
    String username;
    String password;
    boolean correct = false;

    @Override
    public boolean display() {
        AppUser user = new AppUser();
        while (correct == false) {
            System.out.println("\n" + logo + "Log In to Your Account: ");
            System.out.print("Please enter your username: ");
            username = MainActivity.scan.nextLine();
            System.out.print("Please enter your password: ");
            password = MainActivity.scan.nextLine();

            user = UserDao.getInstance().findUser(username,password);
            if (user != null) {
                correct = true;
                System.out.println("Login successful!\n");
                ScreenRouter.getInstance().navigate("/main");
            } else {
                System.out.println("LOGIN FAILED!\n");
                correct = false;
            }
        }
        return correct;
    }

    public boolean login() {
        return false;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}