package com.revature.bank.menus;

import com.revature.bank.MainActivity;
import com.revature.bank.connections.daos.UserDao;

public class MainMenu extends Menu {
    String route = "/main";

    public boolean display() {
        System.out.print("\n" + logo + "MAIN MENU \n" +
                "A. View Accounts\n" +
                "B. Make a Deposit\n" +
                "C. Make a Withdrawal\n" +
                "D. Make a Transfer\n" +
                "E. View Transaction History\n" +
                "X. Log Out\n\n" +
                "Please Select an Option: ");

        switch (input = MainActivity.scan.nextLine().toUpperCase().charAt(0))
        {
            case 'A':
                System.out.println("Case A: View Accounts");
                ScreenRouter.getInstance().navigate("/accounts");
                break;
            case 'B':
                System.out.println("Case B: Make a Deposit");
                ScreenRouter.getInstance().navigate("/deposit");
                break;
            case 'C':
                System.out.println("Case C: Make a Withdrawal");
                ScreenRouter.getInstance().navigate("/withdraw");
                break;
            case 'D':
                System.out.println("Case D: Make a Transfer");
                ScreenRouter.getInstance().navigate("/transfer");
                break;
            case 'E':
                System.out.println("Case E: View Transaction History");
                ScreenRouter.getInstance().navigate("/transactions");
                break;
            case 'X':
            default:
                System.out.println("Case X or Default: Logging Out");
                MainActivity.setAppRunning(false);
                UserDao.getInstance().clearCredentials();
                return false;
        }
        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }

    public void getInput() {}
}