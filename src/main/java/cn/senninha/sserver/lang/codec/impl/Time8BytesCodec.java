package cn.senninha.sserver.lang.codec.impl;

import cn.senninha.sserver.lang.codec.ClassType;
import cn.senninha.sserver.lang.codec.Codec;
import cn.senninha.sserver.lang.codec.field.Field32Bytes;
import cn.senninha.sserver.lang.codec.field.Time8Bytes;
import cn.senninha.sserver.util.MessageUtil;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 支持32个字节的编解码，其实可以搞成动态支持多字节的。。不想动了mmp
 * @author senninha on 2018年1月12日
 *
 */
@ClassType(clazz = Time8Bytes.class)
public class Time8BytesCodec implements Codec {

	@Override
	public void decode(ByteBuffer buf, Object m, Field f) {
		try {
			StringBuilder ts = new StringBuilder();
			Time8Bytes time8 = new Time8Bytes();

			byte[] byteArray1 = new byte[2];
			byteArray1[0] = buf.get();
			byteArray1[1] = buf.get();
			String s1 = MessageUtil.byteArrayToHexStr(byteArray1);
			ts.append(s1);
			ts.append("-");

			byte[] byteArray2 = new byte[1];
			byteArray2[0] = buf.get();
			String s2 = MessageUtil.byteArrayToHexStr(byteArray2);
			ts.append(s2);
			ts.append("-");

			byte[] byteArray3 = new byte[1];
			byteArray3[0] = buf.get();
			String s3 = MessageUtil.byteArrayToHexStr(byteArray3);
			ts.append(s3);
			ts.append(" ");

			for (int i = 0; i < 2; i++) {
				byte[] byteArray4 = new byte[1];
				byteArray4[0] = buf.get();
				String s4 = MessageUtil.byteArrayToHexStr(byteArray4);
				ts.append(s4);
				ts.append(":");
			}

			byte[] byteArray4 = new byte[1];
			byteArray4[0] = buf.get();
			String s4 = MessageUtil.byteArrayToHexStr(byteArray4);
			ts.append(s4);

			buf.get(); // 补位 0xFF

			String s = ts.toString();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date t = ft.parse(s);
			s = String.valueOf(t.getTime());

			time8.setB(s);

			f.setAccessible(true);
			f.set(m, time8);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void encode(ByteBuffer buf, Object m, Field f) {
//		try {
//			f.setAccessible(true);
//			Field32Bytes bytes32 = (Field32Bytes) f.get(m);
//			byte[] b = bytes32.getB();
//			for(int i = 31 ; i >=  0 ; i--) {
//				buf.put(b[i]);
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}

}
