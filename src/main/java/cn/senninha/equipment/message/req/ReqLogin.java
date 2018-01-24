package cn.senninha.equipment.message.req;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.codec.field.Field32Bytes;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

/**
 * 签到
 * @author senninha on 2018年1月13日
 *
 */
@Message(cmd = CmdConstant.REQ_LOGIN)
public class ReqLogin extends BaseMessage {
	private short blank0;
	private Field32Bytes equipmentId;
	//	充电桩软件版本
	private int versions;
	/** 启动次数 */
	private int startNum;
	//	启动间隔时间
	private short loginInterval;
	// 充电枪个数
	private byte connectorNum;
	// 心跳上报周期
	private byte heartInterval;
	// 心跳包检测超时次数
	private byte heartTimeOut;
	/** 充电记录数字 */
	private int chargeSize;
	//当前充电桩系统时间
	private long time;
	private long blank1;
	public short getBlank0() {
		return blank0;
	}
	public void setBlank0(short blank0) {
		this.blank0 = blank0;
	}
	public Field32Bytes getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Field32Bytes equipmentId) {
		this.equipmentId = equipmentId;
	}
	public int getVersions() {
		return versions;
	}
	public void setVersions(int versions) {
		this.versions = versions;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public short getLoginInterval() {
		return loginInterval;
	}
	public void setLoginInterval(short loginInterval) {
		this.loginInterval = loginInterval;
	}
	public byte getConnector() {
		return connectorNum;
	}
	public void setConnector(byte connector) {
		this.connectorNum = connector;
	}
	public byte getHeartInterval() {
		return heartInterval;
	}
	public void setHeartInterval(byte heartInterval) {
		this.heartInterval = heartInterval;
	}
	public byte getHeartTimeOut() {
		return heartTimeOut;
	}
	public void setHeartTimeOut(byte heartTimeOut) {
		this.heartTimeOut = heartTimeOut;
	}
	public int getChargeSize() {
		return chargeSize;
	}
	public void setChargeSize(int chargeSize) {
		this.chargeSize = chargeSize;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getBlank2() {
		return blank1;
	}
	public void setBlank2(long blank2) {
		this.blank1 = blank2;
	}

	
}
