package test;

import com.zengxing.tank.PropertyMgr;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @AuThor：zengxing
 * @DATE:2020/9/13 18:21  250
 */
public class PropertyMgrTest {
    @Test
    public void test(){
        String s = (String) PropertyMgr.get("initTankCount");
        assertNotNull(s);
        assertEquals(s,"10");
    }
}
