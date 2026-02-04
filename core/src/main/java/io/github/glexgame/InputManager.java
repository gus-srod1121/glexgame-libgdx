package io.github.glexgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter {
    private final Player player;
    public InputManager(Player player) { this.player = player; }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                player.velocity.y++;
                break;
            case Input.Keys.S:
                player.velocity.y--;
                break;
            case Input.Keys.A:
                player.velocity.x--;
                break;
            case Input.Keys.D:
                player.velocity.x++;
                break;
        }

        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                player.velocity.y--;
                break;
            case Input.Keys.S:
                player.velocity.y++;
                break;
            case Input.Keys.A:
                player.velocity.x++;
                break;
            case Input.Keys.D:
                player.velocity.x--;
                break;
        }

        return super.keyUp(keycode);
    }
}
