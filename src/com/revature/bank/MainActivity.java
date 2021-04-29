package com.revature.bank;

import java.util.Scanner;

public class MainActivity {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        MainMenu.display();
        scan.close();
    }
}
