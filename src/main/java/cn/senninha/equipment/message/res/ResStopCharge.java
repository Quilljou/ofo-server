package cn.senninha.equipment.message.res;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

@Message(cmd = CmdConstant.RES_STOP_CHARGE)
public class ResStopCharge extends BaseMessage {
	private short blank0;
	private short blank1;
	private byte connector;
	private int cmdStartFlag;
	private byte cmdSize;
	private byte cmdLength;
	private int command;
	
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
	public int getCmdStartFlag() {
		return cmdStartFlag;
	}
	public void setCmdStartFlag(int cmdStartFlag) {
		this.cmdStartFlag = cmdStartFlag;
	}
	public byte getCmdSize() {
		return cmdSize;
	}
	public void setCmdSize(byte cmdSize) {
		this.cmdSize = cmdSize;
	}
	public byte getCmdLength() {
		return cmdLength;
	}
	public void setCmdLength(byte cmdLength) {
		this.cmdLength = cmdLength;
	}
	public int getCommand() {
		return command;
	}
	public void setCommand(int command) {
		this.command = command;
	}
}
