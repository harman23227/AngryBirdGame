package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Pig extends Physics {
    Texture img;
    int size;
    float health;
    static ArrayList<Pig> pigs = new ArrayList<>();
    int hits;

    public Pig(Texture img, int size, float health, int hits, float g, int x, int y) {
        this.gravity = g;
        this.x = x;
        this.y = y;
        this.img = img;
        this.size = size;
        this.health = health;
        this.hits = hits;
        pigs.add(this);

    }

    void take_hit() {

    }

    void get_hit(Bird bird) {

    }

    void get_hit(Structure structure) {

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
