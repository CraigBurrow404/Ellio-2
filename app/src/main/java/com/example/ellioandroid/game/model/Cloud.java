package com.example.ellioandroid.game.model;

import com.example.ellioandroid.framework.util.RandomNumberGenerator;

public class Cloud {
    private float x, y;
    private static final int VEL_X = -15; // Make cloud speed vary per instance []
    //private static final int VEL_X = RandomNumberGenerator.getRandIntBetween(-5, -100);

    public Cloud(float x, float y) {
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
