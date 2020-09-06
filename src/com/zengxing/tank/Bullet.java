package com.zengxing.tank;

import java.awt.*;

/**
 * @AuThor：86150
 * @DATE:2020/9/5 8:41
 * 子弹类
 */
public class Bullet {
    private static final int SPEED =10;
    private int x, y;
    private Dir dir;
    private static int width = 5;
    private static int height = 5;
    private boolean live = true;
    TankFrame tf = null;
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


    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Bullet() {
    }

     /*
     当子弹状态为死亡时，把子弹从
     子弹列表中移除，防止内存泄漏
     */

    public void paint(Graphics g){
        if(!live) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,width,height);
        g.setColor(c);
        move();
    }

    /*当子弹飞出屏幕后，把子弹状态设置为死亡*/

    public void move(){
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
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }
}
