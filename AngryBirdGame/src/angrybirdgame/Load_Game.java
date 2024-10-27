package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.graphics.Color;

public class Load_Game implements Screen {
    private final AngryBirdGame gam;
    private final Skin skin;
    private final Stage stage;
    private final Texture bg;

    public Load_Game(AngryBirdGame game) {
        this.gam = game;
        stage = new Stage(game.viewport, game.batch);

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("gdx-skins-master/freezing/skin/freezing-ui.atlas"));
        skin = new Skin(Gdx.files.internal("gdx-skins-master/freezing/skin/freezing-ui.json"), atlas);

        Gdx.input.setInputProcessor(stage);
        bg = new Texture(Gdx.files.internal("Level_bg.jpeg"));

        createUI();
    }

    private void createUI() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton easyButton = new TextButton("Game 1", skin);
        TextButton mediumButton = new TextButton("Game 2", skin);
        TextButton hardButton = new TextButton("Game 3", skin);

        easyButton.setSize(200, 50);
        mediumButton.setSize(200, 50);
        hardButton.setSize(200, 50);

        addButtonListener(easyButton);
        addButtonListener(mediumButton);
        addButtonListener(hardButton);

        table.add(easyButton).expandX().fillX().pad(20);
        table.add(mediumButton).expandX().fillX().pad(20);
        table.add(hardButton).expandX().fillX().pad(20);

        TextButton goBackButton = new TextButton("Go Back", skin);
        goBackButton.setSize(200, 50);
        goBackButton.setPosition(Gdx.graphics.getWidth() / 2 - goBackButton.getWidth() / 2, 20);

        goBackButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {

                gam.setScreen(new MainMenu(gam));
            }
        });


        addButtonListener(goBackButton);


        stage.addActor(goBackButton);
    }

    private void addButtonListener(TextButton button) {
        button.addListener(new ClickListener() {
            @Override
            public void enter(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
                button.getLabel().setColor(Color.YELLOW);
            }

            @Override
            public void exit(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor toActor) {
                button.getLabel().setColor(Color.WHITE);
            }

            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                System.out.println(button.getText().toString() + " level selected!");
                switch (button.getText().toString()) {
                    case "Game 1":
                        gam.level = new EasyLevel(gam);
                        break;
                    case "Game 2":
                        gam.level = new MediumLevel(gam);
                        break;
                    case "Game 3":
                        gam.level = new HardLevel(gam);
                        break;
                }
                gam.bird = new Bird(new BirdType(100, 10, 1, 1, 10, new Texture(Gdx.files.internal("yellow_bird.png"))), 0, 0);
                gam.setScreen(gam.level);
            }
        });
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gam.batch.begin();
        gam.batch.draw(bg, 10, 0, 800, 540);
        gam.batch.end();


        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {
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
