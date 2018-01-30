package cn.senninha.equipment.handler;

import cn.senninha.equipment.container.PushHelper;
import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.equipment.message.req.ReqAlert;
import cn.senninha.equipment.message.req.ReqHearbeat;
import cn.senninha.equipment.message.req.ReqLogin;
import cn.senninha.equipment.message.res.ResHeartbeat;
import cn.senninha.equipment.message.res.ResLogin;
import cn.senninha.sserver.lang.dispatch.MessageHandler;
import cn.senninha.sserver.lang.dispatch.MessageInvoke;
import cn.senninha.sserver.logger.LoggerManager;
import cn.senninha.sserver.logger.LoggerSystem;
import org.slf4j.Logger;

/**
 * Handler
 * @author senninha on 2018年1月11日
 *
 */
@MessageHandler
public class StatusHandler {
    private Logger logger = LoggerManager.getLogger(LoggerSystem.NET);

    @MessageInvoke(cmd = CmdConstant.REQ_AlERT)
    public void login(String equipmentId, ReqAlert message){
        logger.info(message.toString());

    }



}
