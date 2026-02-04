package io.github.glexgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;

    private Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("player.png");
        player = new Player(Vector2.Zero, image, "Gus", 50f);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        player.position.x += delta * player.getSpeed();
        System.out.println(player.position.x);

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f); //fill color rgba(0.15, 0.15, 0.2, 1)
        batch.begin();
        batch.draw(player.sprite, player.position.x, player.position.y, player.size, player.size);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
