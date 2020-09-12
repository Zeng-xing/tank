package com.zengxing.tank;

import java.awt.*;

/**
 * @AuThor：zengxing
 * @DATE:2020/9/5 8:41
 * 子弹类
 */
public class Bullet {
    private static final int SPEED =10;
    private int x, y;
    private Dir dir;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean living = true;
    private Group group = Group.BAD;
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


    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public Bullet() {
    }

     /*
     当子弹状态为死亡时，把子弹从
     子弹列表中移除，防止内存泄漏
     */

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g){
        if(!living) {
            tf.bullets.remove(this);
        }
        /*Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,width,height);
        g.setColor(c);*/
        switch(dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
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
            living = false;
        }
    }
    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) {
            return;
        }
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if(rect1.intersects(rect2)) {
            tank.die();
            this.die();
            Explode e = new Explode(tank.getX(), tank.getY(), tf);
            tf.explodes.add(e);
        }

    }

    private void die() {
        this.living = false;
    }
}
