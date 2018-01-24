package cn.senninha.equipment.message.res;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

/**
 * 服务器查询充电桩历史充电记录
 * @author senninha on 2018年1月13日
 *
 */
@Message(cmd = CmdConstant.RES_HISTORY_CHARGE_INFO)
public class ResHistoryChargeInfo extends BaseMessage {
	private short blank0;
	private short blank1;
	private int startIndex;
	private int querySize;
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
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getQuerySize() {
		return querySize;
	}
	public void setQuerySize(int querySize) {
		this.querySize = querySize;
	}
	
	
}
