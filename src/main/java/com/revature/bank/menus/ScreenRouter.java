package com.revature.bank.menus;

import com.revature.bank.utils.GenericArrayList;

import java.util.ArrayList;


public class ScreenRouter {
    private static GenericArrayList<Menu> screens = new GenericArrayList<Menu>(9);
    /*
    private StartMenu startMenu = new StartMenu();
    private RegisterScreen registerScreen = new RegisterScreen();
    private LoginScreen loginScreen = new LoginScreen();
    private MainMenu mainMenu = new MainMenu();
    private WithdrawMenu withdrawMenu = new WithdrawMenu();
    private DepositMenu depositMenu = new DepositMenu();
    private TransferMenu transferMenu = new TransferMenu();
    private AccountsMenu accountsMenu = new AccountsMenu();
    private TransactionsMenu transactionsMenu = new TransactionsMenu();
     */

    public ScreenRouter(){}


    public static void addScreen(Menu menu) {
        screens.add(menu);
        //return true;
    }

    public static boolean addScreen(Menu... menu) {
        for (int i = 0; i < menu.length; i++) {
            screens.add(menu[i]);
        }
        return true;
    }

    public static boolean addAllScreens() {
        ScreenRouter.addScreen(new StartMenu());
        ScreenRouter.addScreen(new RegisterScreen());
        ScreenRouter.addScreen(new LoginScreen());
        ScreenRouter.addScreen(new MainMenu());
        ScreenRouter.addScreen(new WithdrawMenu());
        ScreenRouter.addScreen(new DepositMenu());
        ScreenRouter.addScreen(new TransferMenu());
        ScreenRouter.addScreen(new AccountsMenu());
        ScreenRouter.addScreen(new TransactionsMenu());

        return true;
    }
    /*
    public static boolean addAllScreens() {
        ScreenRouter.addScreen(new StartMenu(), new RegisterScreen(), new LoginScreen(), new MainMenu(),
                new WithdrawMenu(), new DepositMenu(), new TransferMenu(), new AccountsMenu(), new TransactionsMenu());
        return true;
    }
     */

    public static boolean navigate(String route) {
        boolean isActive = true;

        for (int i = 0; i < screens.getSize(); i++) {
            Menu currentScreen = (Menu) screens.get(i);
            if (currentScreen.getRoute().equals(route)) {
                isActive = currentScreen.display();
            }
        }
        return isActive;
    }
}