package com.example.ellioandroid.game.model;

import android.graphics.Rect;
import com.example.ellioandroid.framework.util.RandomNumberGenerator;

public class Ground {
    private float groundLeft, groundTop;
    private int groundWidth, groundHeight ;
    private Rect rect;
    private boolean visible;

    public Ground(float x, float y, int width, int height) {
        this.groundLeft = (float) x;
        this.groundTop = (float) y;
        this.groundWidth = (int) width;
        this.groundHeight = (int) height;
        rect = new Rect((int) groundLeft, (int) groundTop, (int) groundLeft + width,
                (int) groundTop + groundHeight);
        visible = true;
    }

    public void update(float delta, float velocityGroundLeft) {
        groundLeft += velocityGroundLeft * delta;
        updateRect();
        if (groundLeft <= -100) {
            reset();
        }
    }

    public void updateRect() {
        rect.set((int) groundLeft, (int) groundTop, (int) groundLeft + groundWidth,
                (int) groundTop + groundHeight);
    }

    public void reset() {
        visible = true; // change this to hide these objects on screen
        groundLeft += 1000;
        updateRect();

    }

    public void onCollide(Player p) {
        visible = false;
        p.pushBack(30); // This needs to change
    }

    public float getGroundLeft() {
        return groundLeft;
    }

    public float getGroundTop() {
        return groundTop;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rect getRect() {
        return rect;
    }
}
