package cn.senninha.equipment.message.req;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.codec.field.Field32Bytes;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

/**
 * 充电记录上传
 * @author senninha on 2018年1月13日
 *
 */
@Message(cmd = CmdConstant.REQ_AlERT)
public class ReqAlert extends BaseMessage {
	private short blank0;
	private short blank1;
	/** 充电桩id */
	private Field32Bytes equipmentId;
	private Field32Bytes alertInfo;
}