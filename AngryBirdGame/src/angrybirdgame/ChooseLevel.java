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

public class ChooseLevel implements Screen {
    private final AngryBirdGame gam;
    private final Skin skin;
    private final Stage stage;
    private final Texture bg;

    public ChooseLevel(AngryBirdGame game) {
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

        TextButton easyButton = new TextButton("Easy", skin);
        TextButton mediumButton = new TextButton("Medium", skin);
        TextButton hardButton = new TextButton("Hard", skin);

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
                    case "Easy":
                        gam.level = new EasyLevel(gam);
                        break;
                    case "Medium":
                        gam.level = new MediumLevel(gam);
                        break;
                    case "Hard":
                        gam.level = new HardLevel(gam);
                        break;
                }
                gam.setScreen(new ChooseBird(gam));


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
