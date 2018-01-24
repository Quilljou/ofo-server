package cn.senninha.sserver.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggerSystem日志管理
 * @author senninha on 2018年1月11日
 *
 */
public class LoggerManager {
	private static LoggerManager inst = new LoggerManager();
	private Logger[] systems = null;
	
	private LoggerManager() {
		init();
	}
	
	private void init() {
		this.systems = new Logger[LoggerSystem.values().length];
		for(LoggerSystem loggerEnum : LoggerSystem.values()) {
			this.systems[loggerEnum.ordinal()] = LoggerFactory.getLogger(loggerEnum.name().toUpperCase());
		}
	}
	
	public static Logger getLogger(LoggerSystem loggerEnum) {
		return inst.systems[loggerEnum.ordinal()];
	}
}
