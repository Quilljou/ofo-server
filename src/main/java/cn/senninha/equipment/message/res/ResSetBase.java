package cn.senninha.equipment.message.res;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.codec.field.Field32Bytes;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

/**
 * 应答充电桩上报的充电信息
 * @author senninha on 2018年1月13日
 *
 */
@Message(cmd = CmdConstant.RES_GETSET)
public class ResSetBase extends BaseMessage {
	private short blank0;
	private short blank1;
	private short type = 0x01;

	
}
