package io.github.glexgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenu implements Screen {
    private final GameGame game;
    private final SpriteBatch batch;

    public MainMenu(GameGame game) {
        this.game = game;
        this.batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLUE);
        batch.begin();
        System.out.println("Hello");
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.switchScreen(GameGame.ScreenName.FOO);
        }
        batch.end();
    }

    @Override
    public void show() { }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
