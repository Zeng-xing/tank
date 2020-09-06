package test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @AuThor：86150
 * @DATE:2020/9/6 11:26
 */
public class ImageTest {
    @Test
    public void test(){
        try {
            BufferedImage image = ImageIO.read(new File("D:/IDEAworkspace/tank/src/images/bulletD.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
