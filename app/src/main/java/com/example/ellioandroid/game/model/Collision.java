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

    public boolean Collision (float missileCentreX, float missileCentreY, int missileRadius,
                              float objectTopLeftX, float objectTopLeftY,
                              int objectHeight, int objectWidth,
                              int collisionType) {

        missileCentreCentreX = missileCentreX;
        missileCentreCentreY = missileCentreY;

        //Caluclate Missile X and Y boundary coordiantes for tests
        missileTopCentreX      = missileCentreX;
        missileCentreLeftX     = missileCentreX - missileRadius;
        missileCentreCentreX   = missileCentreX;
        missileCentreRightX    = missileCentreX + missileRadius;
        missileBottomCentreX   = missileCentreX;
        missileTopCentreY      = missileCentreY - missileRadius;
        missileCentreLeftY     = missileCentreX;
        missileCentreCentreY   = missileCentreX;
        missileCentreRightY    = missileCentreX;
        missileBottomCentreY   = missileCentreY + missileRadius;

        //Calculate Object coordinates
        objectTopLeftX         = objectTopLeftX;
        objectTopRightX        = objectTopLeftX + objectWidth;
        objectBottomLeftX      = objectTopLeftX;
        objectBottomRightX     = objectTopLeftX + objectWidth;
        objectTopLeftY         = objectTopLeftY;
        objectTopRightY        = objectTopLeftY;
        objectBottomLeftY      = objectTopLeftY + objectHeight;
        objectBottomRightY     = objectTopLeftY - objectHeight;

        collided = false;

        if (collisionType == 0) {                       // Collision - Rectangle & Sphere
            if ((missileCentreLeftX >= objectTopLeftX)  // hitting Top side of object
                    && (missileCentreRightX <= objectTopRightX)
                    && (missileTopCentreX >= objectTopLeftY)
                    && (missileBottomCentreY <= objectTopLeftY)) {
                collided = true;
                return collided;
            }

            if ((missileCentreLeftX <= objectTopLeftX) // hitting left side
                    && (missileCentreRightX >= objectTopRightX)
                    && (missileTopCentreY >= objectTopLeftY)
                    && (missileBottomCentreY <= objectBottomLeftY)) {
                collided = true;
                return collided;
            }

            if ((missileCentreLeftX <= objectTopRightX) // hitting right side
                    && (missileCentreRightX >= objectTopRightX)
                    && (missileTopCentreY >= objectTopRightY)
                    && (missileBottomCentreY <= objectBottomRightY)) {
                collided = true;
                return collided;
            }

            if ((missileCentreLeftX <= objectBottomLeftX) // hitting bottom side
                    && (missileCentreRightX >= objectBottomRightX)
                    && (missileTopCentreY >= objectBottomLeftX)
                    && (missileBottomCentreY <= objectBottomLeftX)) {
                collided = true;
                return collided;
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
                return collided;
            }

            if ((missileCentreLeftX <= objectTopLeftX) // hitting top left corner
                    && (missileCentreRightX >= objectTopLeftX)
                    && (missileTopCentreY >= objectTopLeftY)
                    && (missileBottomCentreY <= objectTopLeftY)) {
                collided = true;
                return collided;
            }

            if ((missileCentreLeftX <= objectTopRightX) // hitting top right corner
                    && (missileCentreRightX >= objectTopRightX)
                    && (missileTopCentreY >= objectTopRightY)
                    && (missileBottomCentreY <= objectTopRightY)) {
                collided = true;
                return collided;
            }

            if ((missileCentreLeftX <= objectBottomLeftX) // hitting bottom left corner
                    && (missileCentreRightX >= objectBottomLeftY)
                    && (missileTopCentreY >= objectBottomLeftY)
                    && (missileBottomCentreY <= objectBottomLeftY)) {
                collided = true;
                return collided;
            }

            if ((missileCentreLeftX <= objectBottomRightX) // hitting bottom right corner
                    && (missileCentreRightX >= objectBottomRightX)
                    && (missileTopCentreY >= objectBottomRightY)
                    && (missileBottomCentreY <= objectBottomRightY)) {
                collided = true;
                return collided;
            }

            collided = false;
            return collided;
        }
        return collided;
    }
}