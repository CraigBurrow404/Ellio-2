package com.example.ellioandroid.game.model;

import android.graphics.Rect;

import com.example.ellioandroid.framework.util.RandomNumberGenerator;
import com.example.ellioandroid.game.model.Collision;

public class Missile {

    private float missileTop, missileBottom, missileLeft, missileRight,
            missileCentre, missileVerticalSpeed, missileHorizontalSpeed;
    private int missileWidth, missileHeight, missileType, gravity, airResistance, missileState,
            resetPosition;
    private boolean visible, collided;

    public Missile(float missileTop, float missileLeft, int missileWidth,
                   int missileHeight, int missileType) {
        this.missileTop = missileTop;
        this.missileLeft = missileLeft;
        this.missileWidth = missileWidth;
        this.missileHeight = missileHeight;
        this.missileType = missileType;

        missileCalcs();
        gravity = 600;
        airResistance = 10;
        visible = false;
        resetPosition = 5000;

        /* Missile Types
           0 Offscreen
           1 Bouncing Bomb
           2 Bomb
           3 Laser Blast
           4 Snitcher
           5 Bullet
         100 Explosion
         */

        if (missileType == 0 && missileTop != resetPosition) { // Offscreen
            reset();
        }

        if (missileType == 1) { // Bouncing Bomb
            missileHorizontalSpeed = 25f;
            missileVerticalSpeed = 25f;
            visible = true;
        }
    }

    public void update(float delta) {
        // If Missile just exploded reset it
        if (missileState == 100) {
            reset();
        }
        // Calculate missileSpeeds (Direction)
        missileVerticalSpeed += gravity * delta;
        missileHorizontalSpeed += airResistance * delta;
        // Calculate new position of missile
        missileTop += missileVerticalSpeed;
        missileLeft += missileHorizontalSpeed;
        missileCalcs();

    }

    public void reset() {
        missileHorizontalSpeed = 0;
        missileVerticalSpeed = 0;
        missileTop = resetPosition;
        missileLeft = resetPosition;
        missileCalcs();
        visible = false;
    }

    private boolean isCollided() {
        collided = true;
        return collided;
    }

    private void missileCalcs() {
        missileRight = missileLeft + missileWidth;
        missileBottom = missileTop + missileHeight;
        missileCentre = ((missileTop + missileBottom + missileLeft + missileRight) / 4);
    }

    public boolean isVisible() {
        return visible;
    }

}

