package com.zengxing.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @AuThor：86150
 * @DATE:2020/9/3 16:22
 */
public class T {

        public static void main(String[] args) {
            Frame f = new Frame();
            f.setSize(800, 600);
            f.setResizable(false);
            f.setTitle("tank war");
            f.setVisible(true);
            f.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }

            });
        }

}
