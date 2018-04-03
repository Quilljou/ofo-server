package cn.senninha.equipment.message;

/**
 * cmd常量
 * @author senninha on 2018年1月11日
 *
 */
public class CmdConstant {
	/** --------------------------------------------------- */
	//-------------客户端--->服务端--------------------------//
	/** 握手请求 */
	public static final short REQ_LOGIN = 106;
	/* 查询设置响应 */
	public static final short REQ_GETSET = 4;
	/** 心跳请求 */
	public static final short REQ_HEARTBEAT = 102;
	/** 充电桩状态信息 */
	public static final short REQ_EQUIPMENT = 104;
	/* 告警 */
	public static final short REQ_AlERT = 108;
	/* 电池状态信息*/
	public static final short REQ_BATTERY = 110;

	/** --------------------------------------------------- */
	//-------------服务器--->客户端--------------------------//
	/* 查询设置 */
	public static final short RES_GETSET = 3;
	/** 心跳 */
	public static final short RES_HEARTBEAT = 101;
	/** 握手响应 */
	public static final short RES_LOGIN = 105;
	/* 告警响应  */
	public static final short RES_ALERT = 109;

}
