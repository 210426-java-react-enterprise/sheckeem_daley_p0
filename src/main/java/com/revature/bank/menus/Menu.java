package com.revature.bank.menus;

public abstract class Menu {
    String screenAddress;
    String input;
    String logo = "+-----------+        --        +\n| Bank Bank | a family company |\n+-----------+        --        +\n";
    String menuOptions = null;
    public String display() {
        System.out.println("\n" + logo + menuOptions);
        return screenAddress;
    }

    public abstract String getRoute();
}