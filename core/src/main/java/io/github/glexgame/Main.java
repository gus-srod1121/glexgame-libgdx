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

    private Player player;
    float angle = 0f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Texture texture = new Texture("player.png");
        TextureRegion image = new TextureRegion(texture);
        player = new Player(new Vector2(0f, 0f), image, "Gus", 150f);

        Gdx.input.setInputProcessor(new InputManager(player));
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        // angle += delta * 10f;

        player.position.x += delta * player.getSpeed() * player.velocity.x;
        player.position.y += delta * player.getSpeed() * player.velocity.y;
        System.out.println(player.position);
        System.out.println(player.velocity);

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f); //fill color rgba(0.15, 0.15, 0.2, 1)
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
