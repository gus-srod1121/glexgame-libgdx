package io.github.glexgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class GameGame extends Game {
    public enum ScreenName {
        MAIN_MENU, FOO
    }

    /*
       Private Constants.
     */
    private final HashMap<ScreenName, Screen> screens;

    /*
       Instance Variables.
     */
    private ScreenName currentScreen;

    /*
       Game Singleton.
     */
    private static GameGame game = null;

    private GameGame() { this.screens = new HashMap<>(); }

    /**
     * Returns a GameGame singleton.
     *
     * @return the game as a GameGame
     */
    public static GameGame startGame() {
        if (game == null) {
            game = new GameGame();
        }
        return game;
    }

    public ScreenName getCurrentScene() {
        return this.currentScreen;
    }

    public void switchScreen(ScreenName nextScreen) {
        if (!this.screens.containsKey(nextScreen)) {
            this.screens.put(nextScreen, initScreen(nextScreen));
        }
        this.currentScreen = nextScreen;
        setScreen(this.screens.get(this.currentScreen));
    }

    private Screen initScreen(ScreenName newScreenName) {
        switch (newScreenName) {
            case MAIN_MENU:
                return new MainMenu(this);
            case FOO:
                return new Foo(this);
            default:
                throw new InvalidParameterException();
        }
    }

    @Override
    public void create() {
        switchScreen(ScreenName.MAIN_MENU);
    }

    @Override
    public void dispose() {
        for (Screen screen: screens.values()) {
            if (screen != null) {
                screen.dispose();
            }
        }
    }
}
