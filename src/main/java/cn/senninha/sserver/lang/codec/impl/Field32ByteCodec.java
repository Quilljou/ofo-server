package cn.senninha.sserver.lang.codec.impl;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import cn.senninha.sserver.lang.codec.ClassType;
import cn.senninha.sserver.lang.codec.Codec;
import cn.senninha.sserver.lang.codec.field.Field32Bytes;

/**
 * 支持32个字节的编解码，其实可以搞成动态支持多字节的。。不想动了mmp
 * @author senninha on 2018年1月12日
 *
 */
@ClassType(clazz = Field32Bytes.class)
public class Field32ByteCodec implements Codec {

	@Override
	public void decode(ByteBuffer buf, Object m, Field f) {
		try {
			Field32Bytes bytes32 = new Field32Bytes();
			byte[] b = new byte[32];
			for(int i = 0 ; i < 32 ; i++) {
				b[i] = buf.get();
			}
			bytes32.setB(b);
			f.setAccessible(true);
			f.set(m, bytes32);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void encode(ByteBuffer buf, Object m, Field f) {
		try {
			f.setAccessible(true);
			Field32Bytes bytes32 = (Field32Bytes) f.get(m);
			byte[] b = bytes32.getB();
			for(int i = 0 ; i < 32 ; i++) {
				buf.put(b[i]);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
