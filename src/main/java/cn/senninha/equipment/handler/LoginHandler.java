package cn.senninha.equipment.handler;

import cn.senninha.db.DbManager;
import cn.senninha.equipment.container.ClientContainer;
import cn.senninha.equipment.container.PushHelper;
import cn.senninha.equipment.container.client.Client;
import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.equipment.message.req.ReqHearbeat;
import cn.senninha.equipment.message.req.ReqLogin;
import cn.senninha.equipment.message.res.ResHeartbeat;
import cn.senninha.equipment.message.res.ResLogin;
import cn.senninha.sserver.lang.dispatch.MessageHandler;
import cn.senninha.sserver.lang.dispatch.MessageInvoke;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.logger.LoggerManager;
import cn.senninha.sserver.logger.LoggerSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler
 * @author senninha on 2018年1月11日
 *
 */
@MessageHandler
public class LoginHandler {
    private Logger logger = LoggerManager.getLogger(LoggerSystem.NET);
    private short blank = 0x0000;

    @MessageInvoke(cmd = CmdConstant.REQ_LOGIN)
    public void login(String equipmentId, ReqLogin message){
        logger.info(message.toString());
        ResLogin res = new ResLogin();
        res.setBlank0(blank);
        res.setBlank1(blank);
        PushHelper.sendMessage(equipmentId, res);
    }


    @MessageInvoke(cmd = CmdConstant.REQ_HEARTBEAT)
    public void reqHeart(String equipmentId, ReqHearbeat hearbeat){
        logger.info("收到{}心跳信息", equipmentId);
        ResHeartbeat res = new ResHeartbeat();
        res.setBlank0(blank);
        short heartbeat = 0x0001;
        res.setHeartbeat(heartbeat);
        PushHelper.sendMessage(equipmentId, res);
    }
}
