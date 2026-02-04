package io.github.glexgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private TextureRegion image;

    private Player player;
    float angle = 0f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Texture texture = new Texture("player.png");
        image = new TextureRegion(texture);
        player = new Player(Vector2.Zero, image, "Gus", 50f);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        angle += delta * 10f;
        player.position.x += delta * player.getSpeed();
        System.out.println(player.position.x);

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f); //fill colour rgba(0.15, 0.15, 0.2, 1)
        batch.begin();
        batch.draw(
            player.sprite,
            player.position.x, player.position.y,
            player.size * 0.5f, player.size * 0.5f,
            player.size, player.size,
            1f, 1f,
            angle
        );
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
