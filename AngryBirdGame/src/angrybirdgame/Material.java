package com.github.harman23227.angrybirdgame;

import com.badlogic.gdx.graphics.Texture;

public class Material implements Cloneable {
    Float health;
    Texture img;
    float gravity;

    public Material(float health, float gravity, Texture img) {
        this.health = health;
        this.img = img;
        this.gravity = gravity;
    }

}
