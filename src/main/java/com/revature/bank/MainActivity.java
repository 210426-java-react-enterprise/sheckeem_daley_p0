package com.revature.bank;

import com.revature.bank.menus.ScreenRouter;

import java.util.Scanner;

public class MainActivity {


    private static boolean state = true;
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        /*
        Routing options:
        /start  /register   /login  /main   /withdraw   /deposit    /transfer   /accounts   /transactions
         */
         while (state == true) {
            ScreenRouter.getInstance().addAllScreens();
            state = ScreenRouter.getInstance().navigate("/start");
        };

        scan.close();
    }

    public static boolean isAppRunning() {
        return state;
    }
    public static void setAppRunning(boolean state) {
        MainActivity.state = state;
    }
}
