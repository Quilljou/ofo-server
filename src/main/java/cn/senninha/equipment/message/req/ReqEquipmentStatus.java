package cn.senninha.equipment.message.req;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.codec.field.Field32Bytes;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

/**
 * 充电桩信息
 * @author senninha on 2018年1月13日
 *
 */
@Message(cmd = CmdConstant.REQ_EQUIPMENT)
public class ReqEquipmentStatus extends BaseMessage {
	private short blank0;
	private Field32Bytes equipmentId;
	private short temperature;
	private short humidity;

}