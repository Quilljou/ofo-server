package cn.senninha.equipment.handler;

import cn.senninha.db.DbManager;
import cn.senninha.equipment.container.ClientContainer;
import cn.senninha.equipment.container.PushHelper;
import cn.senninha.equipment.container.client.Client;
import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.equipment.message.res.ResLogin;
import cn.senninha.sserver.lang.dispatch.MessageHandler;
import cn.senninha.sserver.lang.dispatch.MessageInvoke;
import cn.senninha.sserver.lang.message.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handler
 * @author senninha on 2018年1月11日
 *
 */
@MessageHandler
public class LoginHandler {
    private Logger logger = LoggerFactory.getLogger(LoginHandler.class);

    @MessageInvoke(cmd = CmdConstant.REQ_LOGIN)
    public void login(String sessionId, BaseMessage message){
        logger.info(message.toString());
        ResLogin res = new ResLogin();
        short i = 0x0000;
        res.setBlank0(i);
        res.setBlank1(i);
        PushHelper.sendMessage(sessionId, res);
    }
}
