package com.zengxing.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @AuThor：zengxing
 * @DATE:2020/9/13 18:15  250
 */
public class PropertyMgr {
    static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if(properties == null){
            return null;
        }
        return properties.get(key);
    }
}
