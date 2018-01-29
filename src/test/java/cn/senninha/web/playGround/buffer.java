package cn.senninha.web.playGround;

import cn.senninha.sserver.lang.codec.field.Time8Bytes;
import com.sun.jmx.snmp.Timestamp;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class buffer {
    public static void check(ByteBuffer buf) {
        buf.get();
        buf.get();
        System.out.println(buf.position());
    }
    public static byte[] hexStrToByteArray(String str)
    {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] byteArray = new byte[str.length() / 2];
        for (int i = 0; i < byteArray.length; i++){
            String subStr = str.substring(2 * i, 2 * i + 2);
            byteArray[i] = ((byte)Integer.parseInt(subStr, 16));
        }
        return byteArray;
    }

    public static String byteArrayToHexStr(byte[] byteArray) {
        if (byteArray == null){
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[byteArray.length * 2];
        for (int j = 0; j < byteArray.length; j++) {
            int v = byteArray[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }


    public static void decode() {
        byte [] b = hexStrToByteArray("20180129154038");
        ByteBuffer buf = ByteBuffer.wrap(b);
        StringBuilder ts = new StringBuilder();
        try {
            byte[] byteArray1 = new byte[2];
            byteArray1[0] = buf.get();
            byteArray1[1] = buf.get();
            String s1 = byteArrayToHexStr(byteArray1);
            ts.append(s1);
            ts.append("-");

            byte[] byteArray2 = new byte[1];
            byteArray2[0] = buf.get();
            String s2 = byteArrayToHexStr(byteArray2);
            ts.append(s2);
            ts.append("-");

            byte[] byteArray3 = new byte[1];
            byteArray3[0] = buf.get();
            String s3 = byteArrayToHexStr(byteArray3);
            ts.append(s3);
            ts.append(" ");

            for (int i = 0; i < 2; i++) {
                byte[] byteArray4 = new byte[1];
                byteArray4[0] = buf.get();
                String s4 = byteArrayToHexStr(byteArray4);
                ts.append(s4);
                ts.append(":");
            }

            byte[] byteArray4 = new byte[1];
            byteArray4[0] = buf.get();
            String s4 = byteArrayToHexStr(byteArray4);
            ts.append(s4);

            String s = ts.toString();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date t = ft.parse(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        decode();
//        System.out.println(decimalToTimeStatmp());
//        System.out.println(new byte(2312599684546831359));

    }


}