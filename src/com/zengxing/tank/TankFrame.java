package com.zengxing.tank;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @AuThor：86150
 * @DATE:2020/9/3 16:49
 * 坦克游戏方框类
 */
public class TankFrame extends Frame {
    Tank tank = new Tank(200,200,Dir.DOWN,this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;
    public TankFrame(){
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }
    /*解决闪烁问题，采用双缓冲，先在内存中定义一张图片，
    把坦克、背景先画在图片中，在一次性画在屏幕上*/
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.setColor(c);

        tank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }
    class MyKeyListener extends KeyAdapter{
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
            /*if(bL == true){
                x -= 10;
            }
            if(bR == true){
                x += 10;
            }
            if(bU == true){
                y -= 10;
            }
            if(bD == true){
                y += 10;
            }*/
            //repaint方法会自动调用paint方法
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
        public void setMainTankDir(){
            if(!bL && !bD && !bR && !bU){
                tank.setMoving(false);
            }else {
                tank.setMoving(true);
                if(bL) {
                    tank.setDir(Dir.LEFT);
                }
                if(bU) {
                    tank.setDir(Dir.UP);
                }
                if(bR) {
                    tank.setDir(Dir.RIGHT);
                }
                if(bD) {
                    tank.setDir(Dir.DOWN);
                }
            }

        }
    }
}
