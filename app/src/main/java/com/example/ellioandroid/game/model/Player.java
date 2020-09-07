package com.example.ellioandroid.game.model;

import com.example.ellioandroid.simpleandroidgdf.Assets;

import android.graphics.Rect;

public class Player {
    private float playerLeft, playerTop, playerBottom;
    private int playerWidth, playerHeight, velocityPlayerHeight;
    private Rect rect, duckRect;
    private Ground ground;
    private boolean isAlive;
    private boolean isDucked;
    private boolean isGrounded;
    private float duckDuration = .6f;
    private static final int JUMP_VELOCITY = -600;
    private static final int ACCEL_GRAVITY = 1800;

    public Player(float playerLeft, float playerTop, int playerWidth, int playerHeight, Ground ground) {
        this.playerLeft  = playerLeft;
        this.playerTop = playerTop;
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        playerBottom = this.playerHeight + this.playerTop;
        this.ground = ground;
        rect = new Rect();
        //rect.set((int) playerWidth, (int) y, (int) playerWidth + width, (int) y + height);
        rect.set(ground.getRect());
        duckRect = new Rect();
        isAlive = true;
        isDucked = false;
        isGrounded = true;
    }
/*
public void update(float delta) {
    if (duckDuration > 0 && isDucked) {
        duckDuration -= delta;
    } else {
        isDucked = false;
        duckDuration = .6f;
    }
    if (!isGrounded()) {
        velY += ACCEL_GRAVITY * delta;
    } else {
        y = 406 - height;
        velY = 0;
    }
    y += velY * delta;
    updateRects();

 */
    public void update(float delta, Ground playerGround) {
        playerBottom = playerTop + playerHeight;
        if (duckDuration > 0 && isDucked) {
            duckDuration -= delta;
        } else {
            isDucked = false;
            duckDuration = .6f;
        }

        isGrounded = isGrounded();

        if (isGrounded) {
            velocityPlayerHeight = (int) (playerGround.getGroundTop() - playerBottom);
            } else {
            velocityPlayerHeight += ACCEL_GRAVITY * delta;  //Gravity
        }
        playerTop += velocityPlayerHeight * delta;

        updateRects();
    }

    public void updateRects() {
        rect.set((int) playerLeft, (int) playerTop, (int) playerLeft + playerWidth,
                (int) playerTop + playerHeight);
        duckRect.set((int) playerLeft, (int) playerTop, (int) playerLeft + playerWidth,
                (int) playerTop + playerHeight);
    }

    public void jump() {
        if (isGrounded) {
            Assets.playSound(Assets.onJumpID);
            isDucked = false;
            isGrounded = false;
            duckDuration = .6f;
            playerTop -= 100;
            updateRects();
        }
    }

    public void duck() {
        if (isGrounded) {
            isDucked = true;
        }
    }

    public void zapper() {
        if (isGrounded) {
            isDucked = true;
        }
    }

    public void pushBack(int dplayerLeft) {
        playerLeft -= dplayerLeft;
        Assets.playSound(Assets.hitID);
        //if (playerWidth < -width / 2) {
        if (playerLeft < 0) {
            isAlive = false;
        }
        rect.set((int) playerLeft, (int) playerTop, (int) playerLeft + playerWidth,
                (int) playerTop + playerHeight);
    }

    public boolean isGrounded() {

        if ((playerBottom) >= ground.getGroundTop()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDucked() {
        return isDucked;
    }

    public float getPlayerLeft() {
        return playerLeft;
    }

    public float getPlayerTop() {
        return playerTop;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public int getVelocityPlayerHeight() {
        return velocityPlayerHeight;
    }

    public Rect getRect() {
        return rect;
    }

    public Rect getDuckRect() {
        return duckRect;
    }

    public Rect getGround() { return ground.getRect(); }

    public boolean isAlive() { return isAlive; }

    public float getDuckDuration() {
        return duckDuration;
    }
}
