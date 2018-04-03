package cn.senninha.equipment.handler;

import cn.senninha.equipment.container.PushHelper;
import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.equipment.message.req.ReqAlert;
import cn.senninha.equipment.message.req.ReqBatteryStatus;
import cn.senninha.equipment.message.req.ReqEquipmentStatus;
import cn.senninha.equipment.message.res.ResAlert;
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
        ResAlert resAlert = new ResAlert();
        short blank = 0x0000;
        resAlert.setBlank0(blank);
        resAlert.setBlank1(blank);
        PushHelper.sendMessage(equipmentId, resAlert);
    }

    @MessageInvoke(cmd = CmdConstant.REQ_BATTERY)
    public void batteryStatus(String equipmentId, ReqBatteryStatus message) {
        logger.info(message.toString());
    }


    @MessageInvoke(cmd = CmdConstant.REQ_EQUIPMENT)
    public void equipmentStatus(String equipmentId, ReqEquipmentStatus message) {
        logger.info(message.toString());
    }

}
