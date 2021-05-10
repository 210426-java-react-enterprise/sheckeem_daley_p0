package com.revature.bank.menus;

import com.revature.bank.MainActivity;

public class MainMenu extends Menu {
    String route = "/main";

    public boolean display() {
        System.out.print(logo + "What would you like to do today?\n" +
                "A. View Accounts\n" +
                "B. Make a Deposit\n" +
                "C. Make a Withdrawal\n" +
                "D. Make a Transfer\n" +
                "E. View Transaction History\n" +
                "X. Log Out\n" +
                "\n\n" +
                "Please Select an Option: ");

        switch (input = MainActivity.scan.nextLine().toUpperCase().charAt(0))
        {
            case 'A':
                System.out.println("Case A: View Accounts");
                ScreenRouter.navigate("/accounts");
                break;
            case 'B':
                System.out.println("Case B: Make a Deposit");
                ScreenRouter.navigate("/deposit");
                break;
            case 'C':
                System.out.println("Case C: Make a Withdrawal");
                ScreenRouter.navigate("/withdraw");
                break;
            case 'D':
                System.out.println("Case D: Make a Transfer");
                ScreenRouter.navigate("/transfer");
                break;
            case 'E':
                System.out.println("Case E: View Transaction History");
                ScreenRouter.navigate("/transactions");
                break;
            case 'X':
                System.out.println("Case X: Logged Out");
                return false; //breaks loop, ends program (while loop in main())
            default:
                System.out.println("Case Default"); //refreshes current menu
                ScreenRouter.navigate("/menu");
        }
        return true;
    }

    @Override
    protected String getRoute() {
        return route;
    }

    public void getInput() {}
}