package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Structure extends Physics {
    static ArrayList<Structure> structures = new ArrayList<>();
    int height;
    int width;
    Float health;
    Texture img;


    public Structure(Material material, int height, int width, int x, int y) {
        this.health = material.health;
        this.img = material.img;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.gravity = Float.valueOf(material.gravity);
        structures.add(this);
    }

    void gethit(Bird bird) {

    }

    void destroyed() {

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
