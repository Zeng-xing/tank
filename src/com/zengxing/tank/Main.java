package com.zengxing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @AuThor：86150
 * @DATE:2020/9/3 16:22
 */
public class Main {

        public static void main(String[] args) throws InterruptedException {
            TankFrame f = new TankFrame();
            while (true){
                Thread.sleep(50);
                f.repaint();
            }
        }
}
