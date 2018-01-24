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
@Message(cmd = CmdConstant.RES_CHARGE_INFO)
public class ResChargeInfo extends BaseMessage {
	private short blank0;
	private short blank1;
	private byte connector;
	/** 充电卡号 */
	private Field32Bytes userId;
	
	public static ResChargeInfo valueOf(){
		ResChargeInfo res = new ResChargeInfo();
		return res;
	}
	
	public short getBlank0() {
		return blank0;
	}
	public void setBlank0(short blank0) {
		this.blank0 = blank0;
	}
	public short getBlank1() {
		return blank1;
	}
	public void setBlank1(short blank1) {
		this.blank1 = blank1;
	}
	public byte getConnector() {
		return connector;
	}
	public void setConnector(byte connector) {
		this.connector = connector;
	}
	public Field32Bytes getUserId() {
		return userId;
	}
	public void setUserId(Field32Bytes userId) {
		this.userId = userId;
	}
	
	
}
