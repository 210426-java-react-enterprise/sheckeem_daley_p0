package com.revature.bank.menus;

import com.revature.bank.MainActivity;
import com.revature.bank.connections.daos.UserDao;

public class MainMenu extends Menu {
    String route = "/main";
    String menuOptions = "MAIN MENU \n" +
            "A. View Accounts\n" +
            "B. Make a Deposit\n" +
            "C. Make a Withdrawal\n" +
            "D. Make a Transfer\n" +
            "E. View Transaction History\n" +
            "X. Log Out\n\n" +
            "Please Select an Option: ";

    public String display() {
        System.out.print("\n" + logo + menuOptions);

        switch (input = MainActivity.scan.nextLine().toUpperCase())
        {
            case "A":
                System.out.println("Case A: View Accounts");
                ScreenRouter.getInstance().navigate("/accounts");
                break;
            case "B":
                System.out.println("Case B: Make a Deposit");
                ScreenRouter.getInstance().navigate("/deposit");
                break;
            case "C":
                System.out.println("Case C: Make a Withdrawal");
                ScreenRouter.getInstance().navigate("/withdraw");
                break;
            case "D":
                System.out.println("Case D: Make a Transfer");
                ScreenRouter.getInstance().navigate("/transfer");
                break;
            case "E":
                System.out.println("Case E: View Transaction History");
                ScreenRouter.getInstance().navigate("/transactions");
                break;
            case "X":
            default:
                System.out.println("Case X or Default: Logging Out");
                //UserDao.getInstance().clearCredentials();
                screenAddress = "/start";
                return "/start";
        }
        return screenAddress;
    }

    @Override
    public String getRoute() {
        return route;
    }

    public void getInput() {}
}