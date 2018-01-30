package cn.senninha.sserver.lang;

import java.nio.ByteBuffer;

import cn.senninha.sserver.util.MessageUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 将
 * @author senninha on 2017年11月8日
 *
 */
public class ByteBufUtil {
	/**
	 *  {@link ByteBuf} 转化成 {@link ByteBuffer}
	 * @param buf
	 * @return
	 */
	public static ByteBuffer convert(ByteBuf buf){
		ByteBuffer buffer = ByteBuffer.allocate(buf.readableBytes());
		byte[] src = new byte[buf.readableBytes()];
		buf.getBytes(0, src);
		buffer.put(src);
		buffer.flip();
		return buffer;
	}
	
	/**
	 * {@link ByteBuffer} 转化成 {@link ByteBuf}
	 * @param
	 * @return
	 */
	public static ByteBuf convert(ByteBuffer buffer){
		//计算校验和
		byte checkSum = MessageUtil.checkSum(buffer, 0, buffer.limit());
		buffer.put(checkSum);

		//现在才flip
		buffer.flip();
    
		int length = buffer.limit() + 4;
		byte[] src = new byte[length];

		src[0] = (byte) ((Constant.START & 0xff_00) >> 8);
		src[1] = (byte) ((Constant.START & 0x00_ff));
		src[3] = (byte) ((length & 0xff_00) >> 8);
		src[2] = (byte) ((length & 0x00_ff));

		for(int i = 4; i < src.length; i++) {
			src[i] = buffer.get();
		}
		ByteBuf buf = Unpooled.copiedBuffer(src);
		return buf;
	}
}
