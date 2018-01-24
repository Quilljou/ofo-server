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
@Message(cmd = CmdConstant.REQ_BATTERY)
public class ReqBatteryStatus extends BaseMessage {
	private short blank0;
	/** 充电桩id */
	private Field32Bytes equipmentId;
	/* 电池VIN  */
	private long batteryVin;
	/*所位于充电小模块接口编号*/
	private byte moduleLocId;
	/*充电开始时间*/
	private long startTime;
	private long stopTime;
	/*充电时长, 单位min*/
	private short timeLength;
	/*充入容量*/
	private short chargedCapacity;
	private short startChargeCapacity;
	private short curElectricity;
	private short curVoltage;
	private short curTemperature;
	private byte relativeSoc;
	private byte absoluteSoc;
	private short leftCapacity;
	private short fullCapacity;
	private short cycleCount;
	private short blank1;
	private short blank2;
	private short blank3;
}