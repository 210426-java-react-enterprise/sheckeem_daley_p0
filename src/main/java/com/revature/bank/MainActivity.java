package com.revature.bank;

import com.revature.bank.menus.ScreenRouter;
import com.revature.bank.menus.StartMenu;

import java.util.Scanner;

public class MainActivity {


    static boolean isActive = true;
    public static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        while(isActive == true) {
            ScreenRouter.addAllScreens();
            isActive = ScreenRouter.navigate("/start");
        }

        scan.close();
    }
}
