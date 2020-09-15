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
    private int collisionType;

        /* Collision Types
        0 Rectangle with Sphere
        1 Sphere with Sphere
        2 Polymorphic with Sphere
        3 Polymorphic with Sphere
        */

    public booleanCollision {

        missileCentreCentreX = Context.getMissileCentreX(); //*** Got myself in a bit of a pickle
        getMissileCentreY();
        getMissileRadius();
        float objectTopLeftX, float objectTopLeftY,
        int objectWidth, int objectHeight,
        int collisionType)

        //Caluclate Missile X and Y boundary coordiantes for tests
        this.missileTopCentreX      = missileCentreX;
        this.missileCentreLeftX     = missileCentreX - missileRadius;
        this.missileCentreCentreX   = missileCentreX;
        this.missileCentreRightX    = missileCentreX + missileRadius;
        this.missileBottomCentreX   = missileCentreX;
        this.missileTopCentreY      = missileCentreY - missileRadius;
        this.missileCentreLeftY     = missileCentreX;
        this.missileCentreCentreY   = missileCentreX;
        this.missileCentreRightY    = missileCentreX;
        this.missileBottomCentreY   = missileCentreY + missileRadius;

        //Calculate Object coordinates
        this.objectTopLeftX         = objectTopLeftX;
        this.objectTopRightX        = objectTopLeftX + objectWidth;
        this.objectBottomLeftX      = objectTopLeftX;
        this.objectBottomRightX     = objectTopLeftX + objectWidth;
        this.objectTopLeftY         = objectTopLeftY;
        this.objectTopRightY        = objectTopLeftY;
        this.objectBottomLeftY      = objectTopLeftY + objectHeight;
        this.objectBottomRightY     = objectTopLeftY - objectHeight;

        this.collisionType = collisionType;

        collided = false;
        this.collisionType = collisionType;

        if (collisionType == 0) {                            // Collision - Rectangle & Sphere
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