package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.graphics.Texture;

public class BirdType {
    Texture img;
    float health;
    float impact;
    float speed;
    int size;
    float gravity;

    public BirdType(float health, float impact, float speed, int size, float gravity, Texture texture) {
        this.gravity = gravity;
        this.img = texture;
        this.health = health;
        this.impact = impact;
        this.speed = speed;
        this.size = size;
    }
}
