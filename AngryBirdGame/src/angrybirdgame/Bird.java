package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Bird extends Physics {
    Texture img;
    Float health;
    Float impact;
    Float speed;
    int size;
    static ArrayList<Bird> birds = new ArrayList<>();

    public Bird(BirdType birdType, int x, int y) {
        this.img = birdType.img;
        this.x = x;
        this.y = y;
        this.health = birdType.health;
        this.impact = birdType.impact;
        this.speed = birdType.speed;
        this.size = birdType.size;
        this.gravity = birdType.gravity;
        birds.add(this);
    }

    void calculatespeed() {

    }

    @Override
    void calculateangle() {

    }

    @Override
    void calculateimpact() {

    }
}
