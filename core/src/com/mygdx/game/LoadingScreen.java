package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FillViewport;

/**
 * Created by usuario on 28/04/2017.
 */

public class LoadingScreen extends BaseScreen {

    private Stage stage;

    private Skin skin;

    private Label loading;

    public LoadingScreen(MainGame game) {
        super(game);

        stage = new Stage(new FillViewport(640,360));
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        loading = new Label("Loading...",skin);
        loading.setPosition(320 - loading.getWidth() / 2, 180 - loading.getHeight() / 2);
        stage.addActor(loading);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (game.getManager().update()){
            game.finishLoading();
        }else {
            loading.setText("Loading..." + (int)(game.getManager().getProgress() * 100) + "%");
        }

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
