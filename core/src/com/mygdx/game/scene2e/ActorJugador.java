package com.mygdx.game.scene2e;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by spertusatti on 23/04/2017.
 */

public class ActorJugador extends Actor {

    private Texture jugador;

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    private boolean alive;

    public boolean isAlive() {
        return alive;
    }
    public ActorJugador(Texture jugador){
        this.jugador = jugador;
        this.alive = true;
        setSize(jugador.getWidth(), jugador.getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(jugador, getX(), getY());
    }
}
