package cn.senninha.sserver.util;

import java.nio.ByteBuffer;

/**
 * 编码转换工具
 * @author senninha on 2018年1月11日
 *
 */
public class MessageUtil {
	/**
	 * 校验和
	 * @param buffer
	 * @param start 开始下标(包含)
	 * @param end 结束下标(不包含)
	 * @return
	 */
	public static byte checkSum(ByteBuffer buffer, int start, int end) {
		int checkSum = 0;
		for(int i = start ; i < end - start ; i++) {
//			checkSum = ((0xff & buffer.get(i))) + checkSum;
			checkSum = buffer.get(i) + checkSum;
		}
		return (byte) (checkSum & 0xff);
	}

	public static Boolean ischeckSumValid(ByteBuffer buffer) {
	    return checkSum(buffer,0,buffer.limit() - 1) == buffer.get(buffer.limit() - 1);
    }
	
	/**
	 * ascii转为string
	 * @param b 多少个字节都兼容吧orz
	 * @return
	 */
	public static String byte32ChangeToString(byte[] b){
		StringBuilder sb = new StringBuilder(32);
		for(int i = 0 ; i < b.length ; i++){
			sb.append((char) b[i]);
		}
		return sb.toString();
	}
	
	/**
	 * string转为byte[]
	 * @param s
	 * @return
	 */
	public static byte[] stringToByteArray(String s){
		byte[] b = new byte[s.length()];
		for(int i = 0 ; i < s.length() ; i++){
			b[i] = (byte) s.charAt(i);
		}
		return b;
	}


	/**
	 * int转化为对应位数的float
	 * @param value	原值
	 * @param nPoint 保留几位小数点
	 * @return 浮点值
	 */
	public static float intToNPoint(int value, int nPoint){
		float f = 0.0f;
		int tem = 1;
		if(nPoint < 0){
			throw new IllegalArgumentException("can not be negative");
		}
		while(--nPoint >= 0){
		    tem = tem * 10;
		}
		f = ((float) value) / tem;
		return f;
	}

    /**
     * float转化为对应位数的int
     * @param value 原值
     * @param nPoint 保留几位小数
     * @return  返回int
     */
	public static int floatToInt(float value, int nPoint){
	    int i = 0;
	    int tem = 1;
	    if(nPoint < 0){
	        throw new IllegalArgumentException("can not be negative");
        }
        while(--nPoint >= 0){
	        tem = tem * 10;
        }
        i = (int)(value * tem);
	    return i;
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
	
	public static void main(String[] args){
		int i = 10232;
		float f = intToNPoint(i, 2);
		System.out.println(f);
		i = floatToInt(f, 2);

		System.out.println(i);
	}
}
