package com.mygdx.game.scene2e;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by spertusatti on 23/04/2017.
 */

public class ActorPinchos extends Actor {

    private Texture pinchos;

    public ActorPinchos(Texture pinchos){
        this.pinchos = pinchos;
        //Ver limites de textura
        setSize(pinchos.getWidth(), pinchos.getHeight());
    }

    @Override
    public void act(float delta) {
        setX (getX() - 250 * delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(pinchos, getX(), getY());
    }

}
