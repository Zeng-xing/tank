package com.zengxing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @AuThor：86150
 * @DATE:2020/9/3 16:49
 */
public class TankFrame extends Frame {
    private int x = 200;
    private int y = 200;
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
        g.fillRect(x,y,50,50);
    }
    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key){
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    break;
                case KeyEvent.VK_UP:
                    y -= 10;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 10;
                    break;
                default:
                    break;
            }
            //repaint方法会自动调用paint方法
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
