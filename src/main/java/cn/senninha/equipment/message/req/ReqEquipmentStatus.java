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
	/*
	*  j -- 绝缘
	*  z -- 整流模块
	* */
	private short jmuxiandianya1;
	private short jmuxiandianya2;
	private short jzhengduididianzu1;
	private short jzhengduididianzu2;
	private short jfuduididianzu1;
	private short jfuduididianzu2;
	private byte z1zhuangtai;
	private byte z2zhuangtai;
	private short z1huanjingwendu;
	private short z2huanjingwendu;
	private short z1DCsanrewendu;
	private short z1PFCsanrewendu;
	private short z1fengshanzhuansu;
	private short z1sanxiangdianya;
	private short z1shuchudianya;
	private short z1shuchudianliu;
	private short z2DCsanrewendu;
	private short z2PFCsanrewendu;
	private short z2fengshanzhuansu;
	private short z2sanxiangdianya;
	private short z2shuchudianya;
	private short z2shuchudianliu;
	private short blank1;
	private short blank2;

	@Override
	public String toString() {
		return "ReqEquipmentStatus{" +
				"blank0=" + blank0 +
				", equipmentId=" + equipmentId +
				", temperature=" + temperature +
				", humidity=" + humidity +
				", jmuxiandianya1=" + jmuxiandianya1 +
				", jmuxiandianya2=" + jmuxiandianya2 +
				", jzhengduididianzu1=" + jzhengduididianzu1 +
				", jzhengduididianzu2=" + jzhengduididianzu2 +
				", jfuduididianzu1=" + jfuduididianzu1 +
				", jfuduididianzu2=" + jfuduididianzu2 +
				", z1zhuangtai=" + z1zhuangtai +
				", z2zhuangtai=" + z2zhuangtai +
				", z1huanjingwendu=" + z1huanjingwendu +
				", z2huanjingwendu=" + z2huanjingwendu +
				", z1DCsanrewendu=" + z1DCsanrewendu +
				", z1PFCsanrewendu=" + z1PFCsanrewendu +
				", z1fengshanzhuansu=" + z1fengshanzhuansu +
				", z1sanxiangdianya=" + z1sanxiangdianya +
				", z1shuchudianya=" + z1shuchudianya +
				", z1shuchudianliu=" + z1shuchudianliu +
				", z2DCsanrewendu=" + z2DCsanrewendu +
				", z2PFCsanrewendu=" + z2PFCsanrewendu +
				", z2fengshanzhuansu=" + z2fengshanzhuansu +
				", z2sanxiangdianya=" + z2sanxiangdianya +
				", z2shuchudianya=" + z2shuchudianya +
				", z2shuchudianliu=" + z2shuchudianliu +
				", blank1=" + blank1 +
				", blank2=" + blank2 +
				"} " + super.toString();
	}
}