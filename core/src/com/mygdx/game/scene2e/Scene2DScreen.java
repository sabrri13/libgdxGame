package com.mygdx.game.scene2e;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.BaseScreen;
import com.mygdx.game.MainGame;

/**
 * Created by spertusatti on 23/04/2017.
 */

public class Scene2DScreen extends BaseScreen {

    private Stage stage;

    private com.mygdx.game.scene2e.ActorJugador jugador;
    private ActorPinchos pinchos;

    private Texture texturaJugador, texturaPinchos;

    public Scene2DScreen(MainGame game) {
        super(game);
        texturaJugador = new Texture("player.png");
        texturaPinchos = new Texture("pincho.png");
    }
    @Override
    public void show() {

        stage = new Stage();
        stage.setDebugAll(true);

        jugador = new com.mygdx.game.scene2e.ActorJugador(texturaJugador);
        pinchos = new ActorPinchos(texturaPinchos);

        stage.addActor(jugador);
        stage.addActor(pinchos);

        jugador.setPosition(20, 100);
        pinchos.setPosition(500, 100);
    }

    @Override
    public void hide() {
        stage.dispose();

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();

        comprobarColisiones();

        stage.draw();
    }

    private void comprobarColisiones() {
        if(jugador.isAlive() &&
                (jugador.getX() + jugador.getWidth() > pinchos.getX() + pinchos.getWidth())){
            System.out.println("Colisión");
            jugador.setAlive(false);
        }
    }

    @Override
    public void dispose() {
        texturaJugador.dispose();
        texturaPinchos.dispose();
    }
}
