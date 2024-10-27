package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.graphics.Color;

public class Level_End implements Screen {
    private final AngryBirdGame gam;
    private final Skin skin;
    private final Stage stage;
    private final Texture bg;

    public Level_End(AngryBirdGame game) {
        this.gam = game;
        stage = new Stage(game.viewport, game.batch);

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("gdx-skins-master/pixthulhu/skin/pixthulhu-ui.atlas"));
        skin = new Skin(Gdx.files.internal("gdx-skins-master/pixthulhu/skin/pixthulhu-ui.json"), atlas);
        bg = new Texture(Gdx.files.internal("Level_bg.jpeg"));

        Gdx.input.setInputProcessor(stage);

        createUI();
    }

    private void createUI() {
        Table table = new Table();
        table.setFillParent(true);
        table.center();


        table.setSize(200, 150);

        stage.addActor(table);


        TextButton restartButton = new TextButton("Restart", skin);
        TextButton goBackButton = new TextButton("Go to Main Menu", skin);


        float buttonWidth = 100;
        float buttonHeight = 30;

        restartButton.setSize(buttonWidth, buttonHeight);
        goBackButton.setSize(buttonWidth, buttonHeight);


        table.add(restartButton).expandX().padBottom(5);
        table.row();
        table.add(goBackButton).expandX().padBottom(5);


        addButtonListener(restartButton);
        addButtonListener(goBackButton);


        goBackButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gam.setScreen(new MainMenu(gam));
            }
        });
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


            public void clicked(InputEvent event, float x, float y) {
                System.out.println(button.getText().toString() + " level selected!");
                if (button.getText().toString().equals("Restart")) {

                    if (gam.level instanceof EasyLevel) {
                        gam.setScreen(new EasyLevel(gam));
                    } else if (gam.level instanceof MediumLevel) {
                        gam.setScreen(new MediumLevel(gam));
                    } else {
                        gam.setScreen(new HardLevel(gam));
                    }
                }
            }

        });
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gam.batch.begin();
        gam.batch.draw(bg, 0, 0, 800, 540);
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
