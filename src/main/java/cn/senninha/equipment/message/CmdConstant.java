package cn.senninha.equipment.message;

/**
 * cmd常量
 * @author senninha on 2018年1月11日
 *
 */
public class CmdConstant {
	/** --------------------------------------------------- */
	//-------------客户端--->服务端--------------------------//
	/** 签到 */
	public static final short REQ_LOGIN = 106;
	/* 查询设置响应 */
	public static final short REQ_GETSET = 4;
//	/** 上传充电记录 */
//	public static final short REQ_CHARGE_INFO = 202;
	/** 心跳 */
	public static final short REQ_HEARTBEAT = 102;
	/** 充电桩状态信息 */
	public static final short REQ_EQUIPMENT = 104;
	/* 告警 */
	public static final short REQ_AlERT = 108;
	/* 电池状态信息*/
	public static final short REQ_BATTERY = 106;

	/** --------------------------------------------------- */
	//-------------服务器--->客户端--------------------------//
	/* 查询设置 */
	public static final short RES_GETSET = 3;
	/** 停止充电 */
	public static final short RES_STOP_CHARGE = 5;
	/** 开始充电 */
	public static final short RES_START_CHARGE = 9;
	/** 心跳 */
	public static final short RES_HEARTBEAT = 101;
	/** 应答充电桩状态信息 */
	public static final short RES_STATUS = 103;
	/** 应答签到信息 */
	public static final short RES_LOGIN = 105;
	/** 应答上报的充电信息 */
	public static final short RES_CHARGE_INFO = 201;
	/** 应答上传未上传历史充电记录 */
	public static final short RES_HISTORY_CHARGE_INFO = 401;

}
