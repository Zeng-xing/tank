package com.zengxing.tank;

import java.awt.*;

/**
 * @AuThor：86150
 * @DATE:2020/9/4 21:20
 */
public class Tank {
    private int x;
    private int y;
    private static final int SPEED = 10;
    private Dir dir;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Tank() {
    }
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
        switch(dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;

        }
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
