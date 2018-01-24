package cn.senninha.equipment.message.res;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

/**
 * 应答心跳
 * @author senninha on 2018年1月12日
 *
 */
@Message(cmd = CmdConstant.RES_HEARTBEAT)
public class ResHeartbeat extends BaseMessage {
	private short blank0;
	private short heartbeat;
	
	public static ResHeartbeat valueOf(short heartbeat) {
		ResHeartbeat res = new ResHeartbeat();
		res.setHeartbeat(heartbeat);
		return res;
	}
	public short getBlank0() {
		return blank0;
	}
	public void setBlank0(short blank0) {
		this.blank0 = blank0;
	}
	public short getHeartbeat() {
		return heartbeat;
	}
	public void setHeartbeat(short heartbeat) {
		this.heartbeat = heartbeat;
	}
}
