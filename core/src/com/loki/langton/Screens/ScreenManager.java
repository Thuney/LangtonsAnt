package com.loki.langton.Screens;

/**
 * Created by Loki on 6/18/2016.
 */
public class ScreenManager {

    private static Screen lastScreen;
    private static Screen currentScreen;


    public static void setScreen(Screen screen)
    {
        if(currentScreen != null)
        {
            currentScreen.dispose();
        }
        lastScreen = currentScreen;
        currentScreen = screen;
        currentScreen.create();
    }

    public static Screen getCurrentScreen()
    {
        return currentScreen;
    }

    public static Screen getLastScreen(){ return lastScreen; }
}
