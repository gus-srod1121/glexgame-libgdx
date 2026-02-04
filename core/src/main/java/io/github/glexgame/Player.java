package io.github.glexgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Texture sprite;

    private String name;
    private Vector2 position;

    public Player(String name, Vector2 startPos, Texture sprite)
    {
        this.name = name;
        position = startPos;
        this.sprite = sprite;
    }
}
