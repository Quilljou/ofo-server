package cn.senninha.web.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Coded by senninha on 18-1-22
 */
public class ServerConfig {
    public static int port;
    public static int lengthFieldOffset;
    public static int lengthAdjustment;
    public static int initialBytesToStrip;
    public static int lengthFieldLength;


    /**
     * 加载配置
     */
    public static void loadConfig(){
        FileInputStream fis = null;
        try {
            String path = ServerConfig.class.getResource("/").toString();
            path = path.substring(path.indexOf(":") + 1);
            File file = new File(path + "netty.properties");
            if(!file.exists() || file.isDirectory()) {
                System.err.println("配置文件读取错误" + file.getAbsolutePath());
                System.exit(0);
            }
            fis = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(fis);
            load(prop);
            prop.clear();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void load(Properties prop){
        try {
            port = Integer.valueOf(prop.getProperty("netty.port"));
            lengthFieldLength = Integer.valueOf(prop.getProperty("netty.lengthFieldLength"));
            lengthFieldOffset = Integer.valueOf(prop.getProperty("netty.lengthFieldOffset"));
            lengthAdjustment = Integer.valueOf(prop.getProperty("netty.lengthAdjustment"));
            initialBytesToStrip = Integer.valueOf(prop.getProperty("netty.initialBytesToStrip"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
