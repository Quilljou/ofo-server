package cn.senninha.sserver.lang.codec.field;

import java.util.Arrays;

/**
 * 32个字节的特殊字段
 * @author senninha on 2018年1月12日
 *
 */
public class Field32Bytes {
	private byte[] b;

	public byte[] getB() {
		return b;
	}

	public void setB(byte[] b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Field32Bytes{" +
				"b=" + Arrays.toString(b) +
				'}';
	}
}
