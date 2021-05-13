package com.revature.bank;

import com.revature.bank.connections.AppState;
import java.util.Scanner;

public class MainActivity {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        Routing options:
        /start  /register   /login  /main   /withdraw   /deposit    /transfer   /accounts   /transactions
         */
        AppState runningApp = new AppState();
        runningApp.run("/start");

        scan.close();
    }
}
