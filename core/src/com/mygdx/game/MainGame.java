package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class MainGame extends Game {

    public AssetManager manager;

    public AssetManager getManager() {
        return manager;
    }

    public GameScreen gameScreen;

    public  GameOverScreen gameOverScreen;

    public  MenuScreen menuScreen;

    public LoadingScreen loadingScreen;

    @Override
    public void create() {
        manager = new AssetManager();
        manager.load("floor.png", Texture.class);
        manager.load("spike.png", Texture.class);
        manager.load("overfloor.png", Texture.class);
        manager.load("player.png", Texture.class);
        manager.load("logo.png", Texture.class);
        manager.load("die.ogg", Sound.class);
        manager.load("jump.ogg", Sound.class);
        manager.load("song.ogg", Music.class);
        manager.load("gameover.png", Texture.class);

        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);





    }

    public  void finishLoading(){
        gameScreen = new GameScreen(this);
        gameOverScreen = new GameOverScreen(this);
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
    }
}
