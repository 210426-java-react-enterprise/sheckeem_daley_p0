package com.revature.bank;

import com.revature.bank.menus.ScreenRouter;

import java.util.Scanner;

public class MainActivity {


    static boolean isActive = true;
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        /*
        Routing options:
        /start  /register   /login  /main   /withdraw   /deposit    /transfer   /accounts   /transactions
         */
         {
            ScreenRouter.getInstance().addAllScreens();
            isActive = ScreenRouter.getInstance().navigate("/start");
            if (isActive == true) {
                isActive = ScreenRouter.getInstance().navigate("/main");
            } else isActive = false;
        };

        scan.close();
    }
}
