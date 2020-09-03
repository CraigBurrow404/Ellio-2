package com.example.ellioandroid.game.state;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.ellioandroid.framework.util.Painter;
import com.example.ellioandroid.framework.util.RandomNumberGenerator;
import com.example.ellioandroid.game.model.Block;
import com.example.ellioandroid.game.model.Cloud;
import com.example.ellioandroid.game.model.Ground;
import com.example.ellioandroid.game.model.Player;
import com.example.ellioandroid.game.model.Spaceship;
import com.example.ellioandroid.game.model.Zap;
import com.example.ellioandroid.simpleandroidgdf.Assets;
import com.example.ellioandroid.simpleandroidgdf.GameMainActivity;

public class PlayState extends State {
    private Player player;
    private ArrayList<Block> blocks;
    private ArrayList<Zap> zaps;
    private ArrayList<Ground> ground;
    private Cloud cloud, cloud2;
    private Spaceship spaceship1;
    private int playerScore = 0;
    private int groundYCoordinate = 405;
    private static final int BLOCK_HEIGHT = 50;
    private static final int BLOCK_WIDTH = 20;
    private static final int GROUND_HEIGHT = 40;
    private static final int GROUND_WIDTH = 25;
    private static final int ZAP_HEIGHT = 20;
    private static final int ZAP_WIDTH = 20;
    private int blockSpeed = -200;
    private int zapSpeed = -200;
    private int groundSpeed = -40;
    private int heightChange = 0;
    //private static final int PLAYER_WIDTH = 44;
    private static final int PLAYER_WIDTH = 66;
    //private static final int PLAYER_HEIGHT = 61;
    private static final int PLAYER_HEIGHT = 92;

    private float recentTouchY;

    @Override
    public void init() {
        player = new Player(160, GameMainActivity.GAME_HEIGHT - 45
                - PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
        blocks = new ArrayList<Block>();
        zaps = new ArrayList<Zap>();
        ground = new ArrayList<Ground>();
        cloud = new Cloud(100, 100);
        cloud2 = new Cloud(500, 50);
        spaceship1 = new Spaceship(800,10);
        for (int i = 0; i < 5; i++) {
            Block b = new Block(i * 200, GameMainActivity.GAME_HEIGHT - 95,
                    BLOCK_WIDTH, BLOCK_HEIGHT);
            blocks.add(b);
            Zap z = new Zap(i * 200 , GameMainActivity.GAME_HEIGHT - 95,
                    ZAP_WIDTH, ZAP_HEIGHT);
            zaps.add(z);
        }
        for (int i = 0; i < 40; i++) { // Need 10 blocks to make sure both ends are always covered
           // Ground gr = new Ground(i * 100, GameMainActivity.GAME_WIDTH,
            changeHeight(groundYCoordinate);
            Ground gr = new Ground(i * 25, groundYCoordinate,
                    GROUND_WIDTH, GROUND_HEIGHT );
            ground.add(gr);
        }
    }

    @Override
    public void update(float delta) {
        if (!player.isAlive()) {
            setCurrentState(new GameOverState(playerScore / 100));
        }
        playerScore += 1;
        if (playerScore % 500 == 0 && blockSpeed > -280) {
            blockSpeed -= 10;
        }
        if (playerScore % 500 == 0 && zapSpeed > -280) {
            zapSpeed -= 10;
        } // Could change this to projectile speed?
        cloud.update(delta);
        cloud2.update(delta);
        spaceship1.update(delta);
        Assets.runAnim.update(delta);
        player.update(delta);
        updateBlocks(delta);
        updateZaps(delta);
        updateGround(delta);
    }

    private void updateBlocks(float delta) {
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            b.update(delta, blockSpeed);
            if (b.isVisible()) {
                if (player.isDucked()
                        && Rect.intersects(b.getRect(), player.getDuckRect())) {
                    b.onCollide(player);
                } else if (!player.isDucked()
                        && Rect.intersects(b.getRect(), player.getRect())) {
                    b.onCollide(player);
                }
            }
        }
    }

    private void updateZaps(float delta) {
        for (int i = 0; i < zaps.size(); i++) {
            Zap z = zaps.get(i);
            z.update(delta, zapSpeed);
            if (z.isVisible()) {
                if (player.isDucked()
                        && Rect.intersects(z.getRect(), player.getDuckRect())) {
                    z.onCollide(player);
                } else if (!player.isDucked()
                        && Rect.intersects(z.getRect(), player.getRect())) {
                    z.onCollide(player);
                }
            }
        }
    }

    private void updateGround(float delta) {
        for (int i = 0; i < ground.size(); i++) {
            Ground gr = ground.get(i);
            gr.update(delta, groundSpeed);
        }
    }

    @Override
    public void render(Painter g) {
        //g.setColor(Color.rgb(208, 244, 247)); // Set BackGround Colour Here
        g.setColor(Color.rgb(128,128,128));
        g.fillRect(0, 0, GameMainActivity.GAME_WIDTH,
                GameMainActivity.GAME_HEIGHT);
        renderPlayer(g);
        renderBlocks(g);
        renderZaps(g);
        renderSun(g);
        renderClouds(g);
        renderSpaceShip(g);
        renderGround(g);
        //g.drawImage(Assets.grass, 0, 405); // This will change to draw a changing background
        /*
        Maybe change Assets.grass to enable the ground to move around - Not sure the model can
        cope with this at the moment, because I think 405 is hard coded in a few places as the
        ground and this will need to change.
         */
        renderScore(g);
    }

    private void renderScore(Painter g) {
        g.setFont(Typeface.SANS_SERIF, 25);
        g.setColor(Color.BLUE);
        g.drawString("" + playerScore / 100, 20, 30);
    }


    private void renderPlayer(Painter g) {
        if (player.isGrounded()) {
            if (player.isDucked()) {
                g.drawImage(Assets.duck, (int) player.getX(),
                        (int) player.getY());
            } else {
                Assets.runAnim.render(g, (int) player.getX(),
                        (int) player.getY(), player.getWidth(),
                        player.getHeight());
            }
        } else {
            g.drawImage(Assets.jump, (int) player.getX(), (int) player.getY(),
                    player.getWidth(), player.getHeight());
        }
    }

    private void renderBlocks(Painter g) {
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            if (b.isVisible()) {
                g.drawImage(Assets.block, (int) b.getX(), (int) b.getY(),
                        BLOCK_WIDTH, BLOCK_HEIGHT);
            }
        }
    }

    private void renderSun(Painter g) {
        g.setColor(Color.rgb(255, 165, 0));
        g.fillOval(715, -85, 170, 170);
        g.setColor(Color.YELLOW);
        g.fillOval(725, -75, 150, 150);
    }

    private void renderGround(Painter g) {
        for (int i = 0; i < ground.size(); i++) {
            Ground gr = ground.get(i);
            if (gr.isVisible()) {
         //       g.drawImage(Assets.grass, (int) gr.getX(), (int) gr.getY(),
                g.drawImage(Assets.grass, (int) gr.getX(), (int) gr.getY(),
                        GROUND_WIDTH, GROUND_HEIGHT);
            }
        }
    }

    private void renderClouds(Painter g) {
        g.drawImage(Assets.cloud1, (int) cloud.getX(), (int) cloud.getY(), 100,
                60);
        g.drawImage(Assets.cloud2, (int) cloud2.getX(), (int) cloud2.getY(),
               150, 90);
    }

    private void renderSpaceShip(Painter g) {
        g.drawImage(Assets.spaceship1, (int) spaceship1.getX(), (int) spaceship1.getY(), 100,
                60);
     }

    private void renderZaps(Painter g) {
        for (int i = 0; i < zaps.size(); i++) {
            Zap z = zaps.get(i);
            if (z.isVisible()) {
                g.drawImage(Assets.zap, (int) z.getX(), (int) z.getY(),
                        ZAP_WIDTH, ZAP_HEIGHT);
            }
        }
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            recentTouchY = scaledY;
        } else if (e.getAction() == MotionEvent.ACTION_UP) {
            if (scaledY - recentTouchY < -50) {
                player.jump();
            } else if (scaledY - recentTouchY > 50) {
                player.duck();
            }
        }
        return true;
    }

    public void changeHeight(int y) {
        heightChange = RandomNumberGenerator.getRandInt(3);
        if ((heightChange == 0) && (y < 415)) {
            groundYCoordinate += 10;
        } else if ((heightChange == 1 && y > 0)) {
            groundYCoordinate -= 10;
        } ;
    }
}
