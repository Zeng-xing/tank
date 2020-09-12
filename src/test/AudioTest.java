package test;

import org.junit.Test;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * @AuThor：zengxing
 * @DATE:2020/9/12 18:18  250
 */
public class AudioTest {
    @Test
    public void test(){
        byte[] b = new byte[1024*1024*15];
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(AudioTest.class.getClassLoader().getResourceAsStream("audio/tank_move.wav"));
            int read = audioInputStream.read(b);
            System.out.println(read);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
