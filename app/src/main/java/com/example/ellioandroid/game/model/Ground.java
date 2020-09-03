package com.example.ellioandroid.game.model;

import android.graphics.Rect;
import com.example.ellioandroid.framework.util.RandomNumberGenerator;

public class Ground {
    private float x, y;
    private int width, height ;
    private Rect rect;
    private boolean visible;

    public Ground(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height; // this has to change to move the ground around how many ground
        // objects will get used? The images need to be longer to fit any place on screen
        rect = new Rect((int) x, (int) y, (int) x + width, (int) y + height);
        visible = true;
    }

    public void update(float delta, float velX) {
        x += velX * delta;
        updateRect();
        if (x <= -100) {
            reset();
        }
    }

    public void updateRect() {
        rect.set((int) x, (int) y, (int) x + width, (int) y + height);
    }

    public void reset() {
        visible = true; // change this to hide these objects on screen
        // 1 in 3 chance of becoming an Upper Block
        //if (RandomNumberGenerator.getRandInt(3) == 0) {
        //    y = UPPER_Y;
        //} else {
        //    y = LOWER_Y;
        //}
        //y = 405;
        x += 1000;
        updateRect();

    }

    public void onCollide(Player p) {
        visible = false;
        p.pushBack(30); // This needs to change
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rect getRect() {
        return rect;
    }
}
