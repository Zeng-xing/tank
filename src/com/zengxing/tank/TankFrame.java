package com.zengxing.tank;

import javafx.scene.control.Tab;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @AuThor：86150
 * @DATE:2020/9/3 16:49
 * 坦克游戏方框类
 */
public class TankFrame extends Frame {
    Tank tank = new Tank(200,200,Dir.DOWN);
    public TankFrame(){
        setSize(800, 600);
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

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
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
