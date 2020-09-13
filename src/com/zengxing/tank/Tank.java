package com.zengxing.tank;

import java.awt.*;
import java.util.Random;

/**
 * @AuThor：zengxing
 * @DATE:2020/9/4 21:20
 * 坦克类
 */
public class Tank {
    private int x;
    private int y;
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    private static final int SPEED = 2;
    private Dir dir;
    private boolean moving = true;
    private TankFrame tf = null;
    private boolean living = true;
    private Group group = Group.BAD;
    private Random random = new Random();
    int count = 0;
    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }


    public Tank() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /*坦克发射炮弹方法*/
    public void fire() {
        int bX=0;
        int bY=0;
        switch (dir){
            case LEFT:
                bX = this.x - Bullet.WIDTH/2;
                bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
                break;
            case UP:
                bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
                bY = this.y - Bullet.HEIGHT/2;
                break;
            case RIGHT:
                bX = this.x +Tank.WIDTH- Bullet.WIDTH;
                bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
                break;
            case DOWN:
                bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
                bY = this.y + Tank.HEIGHT - Bullet.HEIGHT ;
                break;
        }
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group,this.tf));
        if(this.group == Group.GOOD)
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    /*在游戏框中画出坦克*/
    public void paint(Graphics g){
       /* Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,width,height);
        g.setColor(c);*/
        if(!living) {
            tf.tanks.remove(this);
        }
        /*根据坦克方向画出不同方向的坦克图片*/
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
        /*使坦克随机移动*/
        if(this.group==Group.BAD){
            count++;
            if(count>50){
                count = 0;
                int i = random.nextInt(10);
                if(i>7){
                    dir = Dir.UP;
                }else if(i<=7&&i>=6){
                    dir = Dir.RIGHT;
                }else if(i<=5&&i>=4){
                    dir = Dir.LEFT;
                }else{
                    dir = Dir.DOWN;
                }
            }
        }
        /*边界判断，防止坦克走出游戏框*/
        if (x <= 0 && dir == Dir.LEFT) {
            return;
        }
        if (x >=800-WIDTH && dir == Dir.RIGHT) {
            return;
        }
        if (y <= 0 && dir == Dir.UP) {
            return;
        }
        if (y >= 600-HEIGHT && dir == Dir.DOWN) {
            return;
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

        if(random.nextInt(10) > 8 && this.group==Group.BAD) {
            this.fire();
        }
    }
    public void die() {
        this.living = false;
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
