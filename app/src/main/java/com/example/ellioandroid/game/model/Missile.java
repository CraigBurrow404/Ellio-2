package com.example.ellioandroid.game.model;

import android.graphics.Rect;

import com.example.ellioandroid.framework.util.RandomNumberGenerator;
import com.example.ellioandroid.game.model.Collision;

public class Missile {

    private float missileTop, missileBottom, missileCentreX, missileCentreY, missileRadius,
            missileVerticalSpeed, missileHorizontalSpeed;
    private int missileWidth, missileHeight, missileType, gravity, airResistance, missileState,
            resetPosition;
    private boolean visible, collided;

    public Missile(float missileCentreX, float missileCentreY, int missileRadius,
                   int missileType) {
        this.missileCentreX = missileCentreX;
        this.missileCentreY = missileCentreY;
        this.missileRadius = missileWidth;
        this.missileRadius = missileHeight;
        this.missileType = missileType;

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
        missileCentreY += missileVerticalSpeed;
        missileCentreX += missileHorizontalSpeed;
    }

    public void reset() {
        missileHorizontalSpeed = 0;
        missileVerticalSpeed = 0;
        missileCentreX = resetPosition;
        missileCentreY = resetPosition;
        visible = false;
    }

    private boolean isCollided() {
        collided = true;
        return collided;
    }

    public boolean isVisible() {
        return visible;
    }

    public float getMissileTop() {
        return missileTop;
    }

    public void setMissileTop(float missileTop) {
        this.missileTop = missileTop;
    }

    public float getMissileBottom() {
        return missileBottom;
    }

    public void setMissileBottom(float missileBottom) {
        this.missileBottom = missileBottom;
    }

    public float getMissileCentreX() {
        return missileCentreX;
    }

    public void setMissileCentreX(float missileCentreX) {
        this.missileCentreX = missileCentreX;
    }

    public float getMissileCentreY() {
        return missileCentreY;
    }

    public void setMissileCentreY(float missileCentreY) {
        this.missileCentreY = missileCentreY;
    }

    public float getMissileRadius() {
        return missileRadius;
    }

    public void setMissileRadius(float missileRadius) {
        this.missileRadius = missileRadius;
    }

    public float getMissileVerticalSpeed() {
        return missileVerticalSpeed;
    }

    public void setMissileVerticalSpeed(float missileVerticalSpeed) {
        this.missileVerticalSpeed = missileVerticalSpeed;
    }

    public float getMissileHorizontalSpeed() {
        return missileHorizontalSpeed;
    }

    public void setMissileHorizontalSpeed(float missileHorizontalSpeed) {
        this.missileHorizontalSpeed = missileHorizontalSpeed;
    }

    public int getMissileWidth() {
        return missileWidth;
    }

    public void setMissileWidth(int missileWidth) {
        this.missileWidth = missileWidth;
    }

    public int getMissileHeight() {
        return missileHeight;
    }

    public void setMissileHeight(int missileHeight) {
        this.missileHeight = missileHeight;
    }

    public int getMissileType() {
        return missileType;
    }

    public void setMissileType(int missileType) {
        this.missileType = missileType;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getAirResistance() {
        return airResistance;
    }

    public void setAirResistance(int airResistance) {
        this.airResistance = airResistance;
    }

    public int getMissileState() {
        return missileState;
    }

    public void setMissileState(int missileState) {
        this.missileState = missileState;
    }

    public int getResetPosition() {
        return resetPosition;
    }

    public void setResetPosition(int resetPosition) {
        this.resetPosition = resetPosition;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }
}

