package cn.senninha.equipment.container.client;

import io.netty.channel.ChannelHandlerContext;

/**
 * 客户端实体
 * @author senninha on 2018年1月13日
 *
 */
public class Client {
	private String equipmentId;
	private ChannelHandlerContext ctx;

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public ChannelHandlerContext getCtx() {
		return ctx;
	}

	public void setCtx(ChannelHandlerContext ctx) {
		this.ctx = ctx;
	}
	
	//TODO
	
	
}
