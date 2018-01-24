package cn.senninha.equipment.message.res;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

/**
 * 应答签到信息
 * @author senninha on 2018年1月13日
 *
 */
@Message(cmd = CmdConstant.RES_LOGIN)
public class ResLogin extends BaseMessage {
	private short blank0;
	private short blank1;
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
	
	
}
