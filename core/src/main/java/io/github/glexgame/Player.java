package io.github.glexgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public final Texture sprite;
    public final float size = 200f;
    public Vector2 position;

    private String name;
    private float speed;

    public Player(Vector2 startPos, Texture sprite, String name, float speed)
    {
        this.name = name;
        position = startPos;
        this.sprite = sprite;
        this.speed = speed;
    }

    public Vector2 getPosition() { return position; };
    public float x() { return position.x; }
    public float y() { return position.y; }
    public float getSpeed() { return speed; }

    public void setPosition(Vector2 newPos) {
        position = newPos;
    }

    public void translate(float x, float y) {
        position.x += x;
        position.y += y;
    }

    public void translate(Vector2 newPos) {
        this.translate(newPos.x, newPos.y);
    }

    public void translateX(float x) {
        this.translate(x, 0f);
    }
}
