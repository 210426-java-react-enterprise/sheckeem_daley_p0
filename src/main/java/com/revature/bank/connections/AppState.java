package com.revature.bank.connections;

import com.revature.bank.menus.*;

public class AppState {

    public AppState() {}

    public void run (String screenAddress) {
        boolean running = true;
        ConnectionFactory conn;
        conn = ConnectionFactory.getInstance();

        ScreenRouter route = new ScreenRouter();
        route.addAllScreens();

        while (running) {
            if (screenAddress.equals("/start")) {
                running = false;
                screenAddress = route.navigate(screenAddress);
            }
        }
    }
}
