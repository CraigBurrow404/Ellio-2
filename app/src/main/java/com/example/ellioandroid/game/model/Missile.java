package com.example.ellioandroid.game.model;

import android.graphics.Rect;

import com.example.ellioandroid.framework.util.RandomNumberGenerator;

public class Missile {

    private float missileTop, missileBottom, missileLeft, missileRight,
            missileCentre, missileVerticalSpeed, missileHorizontalSpeed;
    private int missileWidth, missileHeight, missileType,  gravity, airResistance, missileState,
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
        // Test for Collision
        if (isCollided()) {
            missileState = 100;
        }
    }

    public void reset() {
        missileHorizontalSpeed = 0;
        missileVerticalSpeed = 0;
        missileTop = resetPosition;
        missileLeft = resetPosition;
        missileCalcs();
        visible = false;
    }

    private void testForCollision() {
        return;
    }

    private boolean isCollided() {
        collided = true;
        return collided;
    }

    private void missileCalcs () {
        missileRight = missileLeft + missileWidth;
        missileBottom = missileTop + missileHeight;
        missileCentre = ((missileTop + missileBottom + missileLeft + missileRight) / 4);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setMissileTop(float missileTop) {
        this.missileTop = missileTop;
    }

    public void setMissileBottom(float missileBottom) {
        this.missileBottom = missileBottom;
    }

    public void setMissileLeft(float missileLeft) {
        this.missileLeft = missileLeft;
    }

    public void setMissileRight(float missileRight) {
        this.missileRight = missileRight;
    }

    public void setMissileCentre(float missileCentre) {
        this.missileCentre = missileCentre;
    }

    public void setMissileVerticalSpeed(float missileVerticalSpeed) {
        this.missileVerticalSpeed = missileVerticalSpeed;
    }

    public void setMissileHorizontalSpeed(float missileHorizontalSpeed) {
        this.missileHorizontalSpeed = missileHorizontalSpeed;
    }

    public void setMissileWidth(int missileWidth) {
        this.missileWidth = missileWidth;
    }

    public void setMissileHeight(int missileHeight) {
        this.missileHeight = missileHeight;
    }

    public void setMissileType(int missileType) {
        this.missileType = missileType;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public void setAirResistance(int airResistance) {
        this.airResistance = airResistance;
    }

    public void setMissileState(int missileState) {
        this.missileState = missileState;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public float getMissileTop() {
        return missileTop;
    }

    public float getMissileBottom() {
        return missileBottom;
    }

    public float getMissileLeft() {
        return missileLeft;
    }

    public float getMissileRight() {
        return missileRight;
    }

    public float getMissileCentre() {
        return missileCentre;
    }

    public float getMissileVerticalSpeed() {
        return missileVerticalSpeed;
    }

    public float getMissileHorizontalSpeed() {
        return missileHorizontalSpeed;
    }

    public int getMissileWidth() {
        return missileWidth;
    }

    public int getMissileHeight() {
        return missileHeight;
    }

    public int getMissileType() {
        return missileType;
    }

    public int getGravity() {
        return gravity;
    }

    public int getAirResistance() {
        return airResistance;
    }

    public int getMissileState() {
        return missileState;
    }

}

