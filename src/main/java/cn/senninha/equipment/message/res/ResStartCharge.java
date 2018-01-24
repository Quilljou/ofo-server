package cn.senninha.equipment.message.res;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.codec.field.Field32Bytes;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

@Message(cmd = CmdConstant.RES_START_CHARGE)
public class ResStartCharge extends BaseMessage {
	private short blank0;
	private short blank1;
	private byte connector;
	/** 充电生效类型 0：即时充电，1：定时启动充电，2：预约充电 */
	private int chargeEffectType;
	private int blank2;
	/** 充电策略，不明 */
	private int chargeStrategy;
	/** 预约启动时间 */
	private long bookStartTime;
	/** 用户卡号 */
	private Field32Bytes userId;
	/** 断网充电标志 0，不允许，1,允许 */
	private byte chargeOffline;
	/** 离线可充电电量 0.01kw*/
	private int offlineCharge;
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
	public int getChargeEffectType() {
		return chargeEffectType;
	}
	public void setChargeEffectType(int chargeEffectType) {
		this.chargeEffectType = chargeEffectType;
	}
	public int getBlank2() {
		return blank2;
	}
	public void setBlank2(int blank2) {
		this.blank2 = blank2;
	}
	public int getChargeStrategy() {
		return chargeStrategy;
	}
	public void setChargeStrategy(int chargeStrategy) {
		this.chargeStrategy = chargeStrategy;
	}
	public long getBookStartTime() {
		return bookStartTime;
	}
	public void setBookStartTime(long bookStartTime) {
		this.bookStartTime = bookStartTime;
	}
	public Field32Bytes getUserId() {
		return userId;
	}
	public void setUserId(Field32Bytes userId) {
		this.userId = userId;
	}
	public byte getChargeOffline() {
		return chargeOffline;
	}
	public void setChargeOffline(byte chargeOffline) {
		this.chargeOffline = chargeOffline;
	}
	public int getOfflineCharge() {
		return offlineCharge;
	}
	public void setOfflineCharge(int offlineCharge) {
		this.offlineCharge = offlineCharge;
	}
	
	
}
