package com.example.ellioandroid.game.state;

import android.view.MotionEvent;
import com.example.ellioandroid.framework.util.Painter;
import com.example.ellioandroid.simpleandroidgdf.GameMainActivity;

public abstract class State {
    public void setCurrentState(State newState) {
        GameMainActivity.sGame.setCurrentState(newState);
    }

    public abstract void init();

    public abstract void update(float delta);

    public abstract void render(Painter g);

    public abstract boolean onTouch(MotionEvent e, int scaledX, int scaledY);
}