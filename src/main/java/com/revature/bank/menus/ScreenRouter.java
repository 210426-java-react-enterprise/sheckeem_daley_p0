package com.revature.bank.menus;

import com.revature.bank.utils.GenericArrayList;

public class ScreenRouter {
    private GenericArrayList<Menu> screens = new GenericArrayList<Menu>();
    private static ScreenRouter screenRouter;

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

    public static ScreenRouter getInstance() {
        if (screenRouter == null) screenRouter = new ScreenRouter();
        return screenRouter;
    }
    public void addScreen(Menu menu) {
        screens.add(menu);
        //return true;
    }

    public boolean addScreen(Menu... menu) {
        for (int i = 0; i < menu.length; i++) {
            screens.add(menu[i]);
        }
        return true;
    }

    public boolean addAllScreens() {
        addScreen(new StartMenu());
        addScreen(new RegisterScreen());
        addScreen(new LoginScreen());
        addScreen(new MainMenu());
        addScreen(new WithdrawMenu());
        addScreen(new DepositMenu());
        addScreen(new TransferMenu());
        addScreen(new AccountsMenu());
        addScreen(new TransactionsMenu());

        return true;
    }
    /*
    public static boolean addAllScreens() {
        ScreenRouter.addScreen(new StartMenu(), new RegisterScreen(), new LoginScreen(), new MainMenu(),
                new WithdrawMenu(), new DepositMenu(), new TransferMenu(), new AccountsMenu(), new TransactionsMenu());
        return true;
    }
     */

    public boolean navigate(String route) {
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