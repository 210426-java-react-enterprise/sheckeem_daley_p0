package com.revature.bank.menus;

import com.revature.bank.MainActivity;
import com.revature.bank.users.AppUser;
import com.revature.bank.users.UserDao;

import java.sql.Date;
import java.time.LocalDate;

public class RegisterScreen extends Menu {
    String route = "/register";

    @Override
    public boolean display() {
        AppUser user = new AppUser();
        System.out.println("\n\n" + logo + "\nNew User Registration: ");

        System.out.print("Username: \t");
        user.setUsername(MainActivity.scan.nextLine());
        System.out.print("Password: \t");
        user.setPassword(MainActivity.scan.nextLine());
        System.out.print("SSN: \t");
        user.setSsn(Integer.parseInt(MainActivity.scan.nextLine()));
        System.out.print("First Name: \t");
        user.setFirstName(MainActivity.scan.nextLine());
        System.out.print("Last Name: \t");
        user.setLastName(MainActivity.scan.nextLine());
        System.out.print("Email: \t");
        user.setEmail(MainActivity.scan.nextLine());
        System.out.print("Phone: \t");
        user.setPhone(MainActivity.scan.nextLine());
        System.out.print("Sex: \t");

        user.setSex(MainActivity.scan.nextLine());
        user.setClientSince(Date.valueOf(LocalDate.now()));
        user.setClientActive(true);

        UserDao.getInstance().register(user);

        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }
}