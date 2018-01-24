package cn.senninha.sserver.lang.message;

import cn.senninha.sserver.lang.Constant;

/**
 * 通信协议的基础类
 * @author senninha on 2017年11月5日
 *
 */
public class BaseMessage {
	/** 版本号 */
	private byte version;
	/** 序列号域 */
	private byte versionIndex;
	/** 命令字 基数表示服务器下发*/
	private short cmd;
	
	

	public BaseMessage() {
		super();
		this.version = Constant.VERSION;
		this.versionIndex = Constant.VERSION_INDEX;
	}

	public byte getVersion() {
		return version;
	}

	public void setVersion(byte version) {
		this.version = version;
	}

	public byte getVersionIndex() {
		return versionIndex;
	}

	public void setVersionIndex(byte versionIndex) {
		this.versionIndex = versionIndex;
	}

	public short getCmd() {
		return cmd;
	}

	public void setCmd(short cmd) {
		this.cmd = cmd;
	}

	@Override
	public String toString() {
		return "BaseMessage [version=" + version + ", versionIndex=" + versionIndex + ", cmd=" + cmd + "]";
	}
	
}
