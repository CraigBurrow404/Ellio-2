package com.example.ellioandroid.game.model;

import com.example.ellioandroid.game.model.Missile;

public class Collision {

    /* Naming convention is x first then Y second so Top Left - is the highest point of the
     left hand side of the object
    */

    private float missileTopCentreX, missileCentreLeftX, missileCentreCentreX, missileCentreRightX,
            missileBottomCentreX,  missileTopCentreY, missileCentreLeftY, missileCentreCentreY,
            missileCentreRightY, missileBottomCentreY, objectTopLeftX, objectTopRightX,
            objectBottomLeftX, objectBottomRightX, objectTopLeftY, objectTopRightY,
            objectBottomLeftY, objectBottomRightY;

    private boolean collided;

        /* Collision Types
        0 Rectangle with Sphere
        1 Sphere with Sphere
        2 Polymorphic with Sphere
        3 Polymorphic with Sphere
        */

    public Collision (float missileCentreX, float missileCentreY, int missileRadius,
                      float objectTopLeftX, float objectTopLeftY,
                      int objectHeight, int objectWidth,
                      int collisionType) {

        missileCentreCentreX = missileCentreX;
        missileCentreCentreY = missileCentreY;

        //Caluclate Missile X and Y boundary coordiantes for tests
        missileTopCentreX = missileCentreX;
        missileCentreLeftX = missileCentreX - missileRadius;
        missileCentreCentreX = missileCentreX;
        missileCentreRightX = missileCentreX + missileRadius;
        missileBottomCentreX = missileCentreX;
        missileTopCentreY = missileCentreY - missileRadius;
        missileCentreLeftY = missileCentreX;
        missileCentreCentreY = missileCentreX;
        missileCentreRightY = missileCentreX;
        missileBottomCentreY = missileCentreY + missileRadius;

        //Calculate Object coordinates
        objectTopLeftX = objectTopLeftX;
        objectTopRightX = objectTopLeftX + objectWidth;
        objectBottomLeftX = objectTopLeftX;
        objectBottomRightX = objectTopLeftX + objectWidth;
        objectTopLeftY = objectTopLeftY;
        objectTopRightY = objectTopLeftY;
        objectBottomLeftY = objectTopLeftY + objectHeight;
        objectBottomRightY = objectTopLeftY - objectHeight;

        collided = false;
    }

    public void test() {

        if ((missileCentreLeftX >= objectTopLeftX)  // hitting Top side of object
                && (missileCentreRightX <= objectTopRightX)
                && (missileTopCentreX >= objectTopLeftY)
                && (missileBottomCentreY <= objectTopLeftY)) {
            collided = true;
            return;
        }

        if ((missileCentreLeftX <= objectTopLeftX) // hitting left side
                && (missileCentreRightX >= objectTopRightX)
                && (missileTopCentreY >= objectTopLeftY)
                && (missileBottomCentreY <= objectBottomLeftY)) {
            collided = true;
            return;
        }

        if ((missileCentreLeftX <= objectTopRightX) // hitting right side
                && (missileCentreRightX >= objectTopRightX)
                && (missileTopCentreY >= objectTopRightY)
                && (missileBottomCentreY <= objectBottomRightY)) {
            collided = true;
            return;
        }

        if ((missileCentreLeftX <= objectBottomLeftX) // hitting bottom side
                && (missileCentreRightX >= objectBottomRightX)
                && (missileTopCentreY >= objectBottomLeftX)
                && (missileBottomCentreY <= objectBottomLeftX)) {
            collided = true;
            return;
        }

        if ((missileCentreLeftX >= objectTopLeftX) // totally inside object
                && (missileCentreLeftX <= objectTopRightX)
                && (missileCentreRightX >= objectBottomLeftX)
                && (missileCentreRightX <= objectBottomRightX)
                && (missileTopCentreY >= objectTopLeftY)
                && (missileTopCentreY <= objectBottomLeftY)
                && (missileBottomCentreY >= objectTopRightY)
                && (missileBottomCentreY <= objectBottomRightY)) {
            collided = true;
            return;
        }

        if ((missileCentreLeftX <= objectTopLeftX) // hitting top left corner
                && (missileCentreRightX >= objectTopLeftX)
                && (missileTopCentreY >= objectTopLeftY)
                && (missileBottomCentreY <= objectTopLeftY)) {
            collided = true;
            return;
        }

        if ((missileCentreLeftX <= objectTopRightX) // hitting top right corner
                && (missileCentreRightX >= objectTopRightX)
                && (missileTopCentreY >= objectTopRightY)
                && (missileBottomCentreY <= objectTopRightY)) {
            collided = true;
            return;
        }

        if ((missileCentreLeftX <= objectBottomLeftX) // hitting bottom left corner
                && (missileCentreRightX >= objectBottomLeftY)
                && (missileTopCentreY >= objectBottomLeftY)
                && (missileBottomCentreY <= objectBottomLeftY)) {
            collided = true;
            return;
        }

        if ((missileCentreLeftX <= objectBottomRightX) // hitting bottom right corner
                && (missileCentreRightX >= objectBottomRightX)
                && (missileTopCentreY >= objectBottomRightY)
                && (missileBottomCentreY <= objectBottomRightY)) {
            collided = true;
            return;
        }

        collided = false;
        return;

    }

    public float getMissileTopCentreX() {
        return missileTopCentreX;
    }

    public void setMissileTopCentreX(float missileTopCentreX) {
        this.missileTopCentreX = missileTopCentreX;
    }

    public float getMissileCentreLeftX() {
        return missileCentreLeftX;
    }

    public void setMissileCentreLeftX(float missileCentreLeftX) {
        this.missileCentreLeftX = missileCentreLeftX;
    }

    public float getMissileCentreCentreX() {
        return missileCentreCentreX;
    }

    public void setMissileCentreCentreX(float missileCentreCentreX) {
        this.missileCentreCentreX = missileCentreCentreX;
    }

    public float getMissileCentreRightX() {
        return missileCentreRightX;
    }

    public void setMissileCentreRightX(float missileCentreRightX) {
        this.missileCentreRightX = missileCentreRightX;
    }

    public float getMissileBottomCentreX() {
        return missileBottomCentreX;
    }

    public void setMissileBottomCentreX(float missileBottomCentreX) {
        this.missileBottomCentreX = missileBottomCentreX;
    }

    public float getMissileTopCentreY() {
        return missileTopCentreY;
    }

    public void setMissileTopCentreY(float missileTopCentreY) {
        this.missileTopCentreY = missileTopCentreY;
    }

    public float getMissileCentreLeftY() {
        return missileCentreLeftY;
    }

    public void setMissileCentreLeftY(float missileCentreLeftY) {
        this.missileCentreLeftY = missileCentreLeftY;
    }

    public float getMissileCentreCentreY() {
        return missileCentreCentreY;
    }

    public void setMissileCentreCentreY(float missileCentreCentreY) {
        this.missileCentreCentreY = missileCentreCentreY;
    }

    public float getMissileCentreRightY() {
        return missileCentreRightY;
    }

    public void setMissileCentreRightY(float missileCentreRightY) {
        this.missileCentreRightY = missileCentreRightY;
    }

    public float getMissileBottomCentreY() {
        return missileBottomCentreY;
    }

    public void setMissileBottomCentreY(float missileBottomCentreY) {
        this.missileBottomCentreY = missileBottomCentreY;
    }

    public float getObjectTopLeftX() {
        return objectTopLeftX;
    }

    public void setObjectTopLeftX(float objectTopLeftX) {
        this.objectTopLeftX = objectTopLeftX;
    }

    public float getObjectTopRightX() {
        return objectTopRightX;
    }

    public void setObjectTopRightX(float objectTopRightX) {
        this.objectTopRightX = objectTopRightX;
    }

    public float getObjectBottomLeftX() {
        return objectBottomLeftX;
    }

    public void setObjectBottomLeftX(float objectBottomLeftX) {
        this.objectBottomLeftX = objectBottomLeftX;
    }

    public float getObjectBottomRightX() {
        return objectBottomRightX;
    }

    public void setObjectBottomRightX(float objectBottomRightX) {
        this.objectBottomRightX = objectBottomRightX;
    }

    public float getObjectTopLeftY() {
        return objectTopLeftY;
    }

    public void setObjectTopLeftY(float objectTopLeftY) {
        this.objectTopLeftY = objectTopLeftY;
    }

    public float getObjectTopRightY() {
        return objectTopRightY;
    }

    public void setObjectTopRightY(float objectTopRightY) {
        this.objectTopRightY = objectTopRightY;
    }

    public float getObjectBottomLeftY() {
        return objectBottomLeftY;
    }

    public void setObjectBottomLeftY(float objectBottomLeftY) {
        this.objectBottomLeftY = objectBottomLeftY;
    }

    public float getObjectBottomRightY() {
        return objectBottomRightY;
    }

    public void setObjectBottomRightY(float objectBottomRightY) {
        this.objectBottomRightY = objectBottomRightY;
    }

    public boolean isCollided() {
        return collided;
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }
}