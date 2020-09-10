package com.example.ellioandroid.game.model;

import com.example.ellioandroid.simpleandroidgdf.Assets;

import android.graphics.Rect;

public class Player {
    private float playerLeft, playerTop, playerBottom;
    private int playerWidth, playerHeight, velocityPlayerHeight;
    private Rect rect, duckRect;
    private Ground ground;
    /* playerStates
    0 Running on the Ground
    1 Jumping
    2 Ducked
    3 Somersault
    4 Jet Pack
    5 Double Jump
    6 Karate Kick
    */
    private short playerState;
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
        /* playerStates
              0 Running on the Ground
              1 Jumping
              2 Ducked
              3 Somersault
              4 Jet Pack
              5 Double Jump
              6 Karate Kick
        */
        playerState = 0;
    }
    public void updatePlayerStateAndHeight(float playerLeft, float playerTop, int playerWidth,
                                           int playerHeight, Ground ground, float delta) {
        this.playerLeft  = playerLeft;
        this.playerTop = playerTop;
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        playerBottom = this.playerHeight + this.playerTop;
        this.ground = ground;

        // Test playerState
        if (playerState == 0) { // Running on the Ground
            playerBottom = ground.getGroundTop();

        } else if (playerState == 1) { // Jumping
            velocityPlayerHeight += ACCEL_GRAVITY * delta;
            playerBottom += velocityPlayerHeight;
            // Test if player has reached the Ground
            if (playerBottom >= ground.getGroundTop()) {
                playerState = 0;
                playerBottom = ground.getGroundTop();
            }
        } else if (playerState == 2) { // Ducking
            // Check if already Ducked
            if (duckDuration > 0) {
                duckDuration -= delta;
            } else {
                playerState = 0;
                duckDuration = .6f;
            /*
            } else if (playerState == 3) {
                // Somersault
            } else if (playerState == 4) {
                // Jet Packing
            } else if (playerState == 5) {
                // Double Jumping
            } else if (playerState == 6) {
                // Karate Kick
            */
            }
        }
        playerTop = playerBottom - playerHeight;
    }

    public void updateRects() {
        rect.set((int) playerLeft, (int) playerTop, (int) playerLeft + playerWidth,
                (int) playerTop + playerHeight);
        duckRect.set((int) playerLeft, (int) playerTop, (int) playerLeft + playerWidth,
                (int) playerTop + playerHeight);
    }

    public void jump() {
             Assets.playSound(Assets.onJumpID);
            duckDuration = .6f;
            playerTop -= 100;
            updateRects();
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
            playerTop = playerBottom - playerHeight -1;
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
