package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.Color;

public class ChooseBird implements Screen {
    private final AngryBirdGame gam;
    private final Skin skin;
    private final Stage stage;
    private final SpriteBatch batch;
    private TextButton easyButton;
    private TextButton mediumButton;
    private TextButton hardButton;
    private final Texture bg;


    private final Texture redBirdTexture;
    private final Texture blueBirdTexture;
    private final Texture yellowBirdTexture;


    private final float buttonWidth = 200;
    private final float buttonHeight = 50;
    private final float birdWidth = 100;
    private final float birdHeight = 100;

    public ChooseBird(AngryBirdGame game) {
        this.gam = game;
        this.batch = game.batch;
        stage = new Stage(game.viewport, batch);


        redBirdTexture = new Texture(Gdx.files.internal("red_bird.png"));
        blueBirdTexture = new Texture(Gdx.files.internal("blue_bird.png"));
        yellowBirdTexture = new Texture(Gdx.files.internal("yellow_bird.png"));

        skin = new Skin(Gdx.files.internal("gdx-skins-master/pixthulhu/skin/pixthulhu-ui.json"));

        Gdx.input.setInputProcessor(stage);
        bg = new Texture(Gdx.files.internal("Bird_bg.jpeg"));


        createUI();
    }

    private void createUI() {

        easyButton = new TextButton("Red Bird", skin);
        mediumButton = new TextButton("Blue Bird", skin);
        hardButton = new TextButton("Yellow Bird", skin);

        easyButton.setSize(buttonWidth, buttonHeight);
        mediumButton.setSize(buttonWidth, buttonHeight);
        hardButton.setSize(buttonWidth + 50, buttonHeight);


        float viewportWidth = stage.getViewport().getWorldWidth();
        float viewportHeight = stage.getViewport().getWorldHeight();


        float centerY = viewportHeight / 2 - buttonHeight / 2;
        float margin = 40;


        float totalButtonWidth = buttonWidth * 3 + margin * 2;


        float startX = (viewportWidth - totalButtonWidth) / 2;


        easyButton.setPosition(startX, centerY);
        mediumButton.setPosition(startX + buttonWidth + margin, centerY);
        hardButton.setPosition(startX + 2 * (buttonWidth + margin), centerY);

        addButtonListener(easyButton);
        addButtonListener(mediumButton);
        addButtonListener(hardButton);


        stage.addActor(easyButton);
        stage.addActor(mediumButton);
        stage.addActor(hardButton);
    }


    private void addButtonListener(TextButton button) {
        button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
                button.getLabel().setColor(Color.YELLOW);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor toActor) {
                button.getLabel().setColor(Color.WHITE);
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println(button.getText().toString() + " selected!");
                switch (button.getText().toString()) {
                    case "Red Bird":
                        gam.bird = new Bird(new BirdType(100, 10, 1, 1, 10, new Texture(Gdx.files.internal("red_bird.png"))), 0, 0);
                        System.out.println(gam.bird);
                        break;
                    case "Blue Bird":
                        gam.bird = new Bird(new BirdType(100, 10, 1, 1, 10, new Texture(Gdx.files.internal("blue_bird.png"))), 0, 0);
                        break;
                    case "Yellow Bird":
                        gam.bird = new Bird(new BirdType(100, 10, 1, 1, 10, new Texture(Gdx.files.internal("yellow_bird.png"))), 0, 0);
                        break;
                }
                gam.setScreen(gam.level);
            }
        });
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


        batch.begin();

        float birdY = easyButton.getY() + easyButton.getHeight() + 10;
        batch.draw(redBirdTexture, easyButton.getX() + (buttonWidth - birdWidth) / 2, birdY, birdWidth, birdHeight);
        batch.draw(blueBirdTexture, mediumButton.getX() + (buttonWidth - birdWidth) / 2, birdY, birdWidth, birdHeight);
        batch.draw(yellowBirdTexture, hardButton.getX() + (buttonWidth - birdWidth) / 2, birdY, birdWidth, birdHeight);
        batch.end();


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
        redBirdTexture.dispose();
        blueBirdTexture.dispose();
        yellowBirdTexture.dispose();
    }
}
