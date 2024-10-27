package com.github.harman23227.angrybirdgame;

public abstract class Physics {
    int x;
    int y;
    float gravity;

    abstract void calculatespeed();

    abstract void calculateangle();

    abstract void calculateimpact();
}
