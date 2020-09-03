package com.example.ellioandroid.game.model;

import com.example.ellioandroid.framework.util.RandomNumberGenerator;

public class Spaceship   {
    private float x, y;
    private static final int VEL_X = -90;

    public Spaceship(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void update(float delta) {
        x += VEL_X * delta;
        if (x <= -200) {
            // Reset to the right
            x += 1000;
            y = RandomNumberGenerator.getRandIntBetween(20, 100);
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
