package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.mygdx.game.Constants.PIXELS_IN_METER;

/**
 * Created by usuario on 27/04/2017.
 */

public class SpikeEntity extends Actor {
    private Texture texture;
    private World world;
    private Body body;
    private Fixture fixture;
    private boolean alive = true, jumping = false;

    public SpikeEntity(World world, Texture texture, float x, float y) {
        this.world = world;
        this.texture  = texture;

        BodyDef def = new BodyDef();
        def.position.set(x, y + 0.5f);
        body = world.createBody(def);

        PolygonShape box = new PolygonShape();

        Vector2[] vertices = new Vector2[3];
        vertices[0] = new Vector2(-0.5f, -0.5f);
        vertices[1] = new Vector2(0.5f, -0.5f);
        vertices[2] = new Vector2(0, 0.5f);
        box.set(vertices);
        fixture = body.createFixture(box, 1);
        fixture.setUserData("spike");
        box.dispose();

        setPosition((x - 0.5f) * PIXELS_IN_METER, y * PIXELS_IN_METER);
        setSize(PIXELS_IN_METER, PIXELS_IN_METER);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void detach() {
        body.destroyFixture(fixture);
        world.destroyBody(body);

    }
}
