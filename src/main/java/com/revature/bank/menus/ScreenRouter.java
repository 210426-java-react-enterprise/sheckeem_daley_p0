package com.revature.bank.menus;

import com.revature.bank.utils.GenericArrayList;

public class ScreenRouter {
    private GenericArrayList<Menu> screens = new GenericArrayList<Menu>(1);
    private static ScreenRouter screenRouter;
    private Menu currentScreen;
    private String screenAddress;

    public static ScreenRouter getInstance() {
        if (screenRouter == null) screenRouter = new ScreenRouter();
        screenRouter.addAllScreens();
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
        addScreen(new StartMenu());

        return true;
    }

    public String navigate(String route) {
        /*
        Routing options:
        /start  /register   /login  /main   /withdraw   /deposit    /transfer   /accounts   /transactions
         */
        Boolean loop = true;
        int i =0;
        do {
            currentScreen = screens.get(i);
            screenAddress = currentScreen.getRoute();
            if (currentScreen != null && screenAddress.equals(route)) {
                loop = false;
                currentScreen.display();
            } else if (currentScreen != null) {
                i++;
            } else i = 0;
        } while (loop);
        return screenAddress;
    }

    public Menu getCurrentScreen(){
        return currentScreen;
    }
}