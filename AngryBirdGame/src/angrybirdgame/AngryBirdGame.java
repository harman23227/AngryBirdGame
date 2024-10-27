package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class AngryBirdGame extends Game {
    public SpriteBatch batch;
    public OrthographicCamera camera;
    public Viewport viewport;
    public MainMenu mainMenuScreen;
    public Screen level;
    public Bird bird;

    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(800, 480, camera);

        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
        camera.update();

        setScreen(new MainMenu(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        if (getScreen() != null) {
            getScreen().dispose();
        }
        batch.dispose();
    }

    public void setScreen(Screen screen) {
        Screen currentScreen = getScreen();

        if (currentScreen != null) {

            if (currentScreen instanceof ChooseLevel || currentScreen instanceof ChooseBird || currentScreen instanceof Pause || currentScreen instanceof Level_End || currentScreen instanceof Load_Game) {
                currentScreen.dispose();
            } else {
                currentScreen.hide();
            }
        }
        super.setScreen(screen);
    }

}
