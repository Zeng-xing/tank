package com.zengxing.tank;
/**
 * @AuThor：zengxing
 * @DATE:2020/9/3 16:22
 *
 */
public class Main {

        public static void main(String[] args) throws InterruptedException {
            TankFrame f = new TankFrame();
            for(int i=0; i<5; i++) {
                f.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN,Group.BAD, f));
            }
            while (true){
                Thread.sleep(50);
                f.repaint();
            }
        }
}
