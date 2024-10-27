package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.graphics.Color;

public class MainMenu implements Screen {
    private final AngryBirdGame gam;
    private final Skin skin;
    private final Stage stage;
    private final Texture bg;

    public MainMenu(AngryBirdGame game) {
        this.gam = game;
        game.mainMenuScreen = this;

        stage = new Stage(game.viewport, game.batch);


        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("gdx-skins-master/freezing/skin/freezing-ui.atlas"));
        skin = new Skin(Gdx.files.internal("gdx-skins-master/freezing/skin/freezing-ui.json"), atlas);


        Gdx.input.setInputProcessor(stage);
        bg = new Texture(Gdx.files.internal("MainScreen2.jpeg"));


        createUI();
    }

    private void createUI() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton newGameButton = new TextButton("New Game", skin);
        TextButton loadGameButton = new TextButton("Load Game", skin);
        TextButton exitButton = new TextButton("Exit", skin);
        newGameButton.setSize(300, 75);
        loadGameButton.setSize(300, 75);
        exitButton.setSize(300, 75);

        newGameButton.addListener(new ClickListener() {
            @Override
            public void enter(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
                newGameButton.getLabel().setColor(Color.YELLOW);
            }

            @Override
            public void exit(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor toActor) {
                newGameButton.getLabel().setColor(Color.WHITE);
            }

            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                gam.setScreen(new ChooseLevel(gam));
            }
        });

        loadGameButton.addListener(new ClickListener() {
            @Override
            public void enter(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
                loadGameButton.getLabel().setColor(Color.YELLOW);
            }

            @Override
            public void exit(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor toActor) {
                loadGameButton.getLabel().setColor(Color.WHITE);
            }

            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                gam.setScreen(new Load_Game(gam));
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void enter(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
                exitButton.getLabel().setColor(Color.YELLOW);
            }

            @Override
            public void exit(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor toActor) {
                exitButton.getLabel().setColor(Color.WHITE);
            }

            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });


        table.add(newGameButton).fillX().uniformX().size(200, 75);
        table.row().pad(20, 0, 20, 0);
        table.add(loadGameButton).fillX().uniformX().size(200, 75);
        table.row().pad(20, 0, 10, 0);
        table.add(exitButton).fillX().uniformX().size(200, 75);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gam.batch.begin();
        gam.batch.draw(bg, 10, 0, 800, 540);
        gam.batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        skin.dispose();
        stage.dispose();
    }
}
