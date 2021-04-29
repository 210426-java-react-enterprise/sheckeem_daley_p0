package com.revature.bank;

import java.util.Scanner;

public class MainMenu extends Inputs implements Menu{
    public static void display() {
        char input;

        System.out.print("+-----------+        --        +\n| Bank Bank | a family company |\n+-----------+        --        +\n" +
                "What would you like to do today?\n" +
                "A. View Accounts\n" +
                "B. Make a Deposit\n" +
                "C. Make a Withdrawal\n" +
                "D. Make a Transfer\n" +
                "E. View Transaction History\n\n" +
                "Select an Option: ");

        switch (input = MainActivity.scan.nextLine().toUpperCase().charAt(0))
        {
            case 'A':
                System.out.println("Case A");
                break;
            case 'B':
                System.out.println("Case B");
                break;
            case 'C':
                System.out.println("Case C");
                break;
            case 'D':
                System.out.println("Case D");
                break;
            case 'E':
                System.out.println("Case E");
                break;
            default:
                System.out.println("Case Default");
        }

    }
    public void getInput() {}
}