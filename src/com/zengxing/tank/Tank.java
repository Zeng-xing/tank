package com.zengxing.tank;

import java.awt.*;

/**
 * @AuThor：86150
 * @DATE:2020/9/4 21:20
 * 坦克类
 */
public class Tank {
    private int x;
    private int y;
    private static int width = 50;
    private static int height = 50;
    private static final int SPEED = 5;
    private Dir dir;
    private boolean moving = false;
    private TankFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Tank() {
    }
    /*坦克发射炮弹方法*/
    public void fire() {
        tf.bullets.add(new Bullet(this.x+width/2, this.y+height/2, this.dir, this.tf));
    }

    /*在游戏框中画出坦克*/
    public void paint(Graphics g){
       /* Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,width,height);
        g.setColor(c);*/
        switch(dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }

        move();
    }

    /*坦克移动方法*/
    public void move(){
        if(!moving){
            return;
        }
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
            default:
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
