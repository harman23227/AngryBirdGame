package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HardLevel implements Screen {
    private final AngryBirdGame game;
    private final SpriteBatch batch;
    private Structure structure;
    private Bird bird;
    private final Texture bg;
    private Pig pig;
    private Texture sling;


    public HardLevel(AngryBirdGame game) {
        this.game = game;
        this.batch = game.batch;
        initializeLevel();
        bg = new Texture(Gdx.files.internal("Bird_bg.jpeg"));
    }

    private void initializeLevel() {

        Material wood = new Material(100, 10, new Texture(Gdx.files.internal("Metal/Metal_08-512x512.png")));
        structure = new Structure(wood, 100, 100, Gdx.graphics.getWidth() / 2, 0);
        pig = new Pig(new Texture(Gdx.files.internal("pig.png")), 1, 100, 2, 10, structure.x, structure.y + 50);
        sling = new Texture(Gdx.files.internal("Slingshot .png"));

    }

    public void setBird(Bird selectedBird) {
        this.bird = selectedBird;
    }

    @Override
    public void show() {
        System.out.println("created bird");
        this.bird = game.bird;
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.P)) {

            game.setScreen(new Pause(game));
            return;
        }
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.W)) {

            game.setScreen(new Level_End(game));
            return;
        }


        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(bg, 0, 0, 800, 540);
        game.batch.end();


        batch.begin();
        batch.draw(structure.img, structure.x, structure.y + 20, structure.width, structure.height);


        batch.draw(game.bird.img, 0, structure.y + 20, 40f, 40f);
        batch.draw(pig.img, pig.x + 20, pig.y + 70, 40f, 40f);
        batch.draw(sling, 50, structure.y + 20, 80f, 148f);


        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        structure.img.dispose();
        if (bird != null) {
            bird.img.dispose();
        }
    }
}
