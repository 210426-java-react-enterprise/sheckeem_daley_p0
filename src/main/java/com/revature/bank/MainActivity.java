package com.revature.bank;

import com.revature.bank.menus.ScreenRouter;

import java.util.Scanner;

public class MainActivity {


    static boolean isActive = true;
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        while(isActive == true) {
            ScreenRouter.getInstance().addAllScreens();
            isActive = ScreenRouter.getInstance().navigate("/start");
        }

        scan.close();
    }
}
