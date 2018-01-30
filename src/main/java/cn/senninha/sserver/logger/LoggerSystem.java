package cn.senninha.sserver.logger;

import org.slf4j.Logger;

/**
 * 日志枚举
 * @author senninha on 2018年1月11日
 *
 */
public enum LoggerSystem {
	/** 网络层 */
	NET,
	/** 结算 */
	CHECKOUT,
	/** web接口访问日志 */
	WEB_INTERFACE_ACCESS,
	/** 系统初始化相关日志 */
	SYSTEM_INIT,
	;

	public Logger getLogger() {
		return LoggerManager.getLogger(this);
	}
}
