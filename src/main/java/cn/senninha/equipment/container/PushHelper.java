package cn.senninha.equipment.container;

import cn.senninha.equipment.container.client.Client;
import cn.senninha.sserver.lang.message.BaseMessage;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * 推送信息帮助类
 * Coded by senninha on 18-1-22
 */
public class PushHelper {
    /**
     * 发送信息
     * @param client
     * @param message
     */
    public static void sendMessage(Client client, BaseMessage message){
        if(client == null || message == null){
            return;
        }

        ChannelHandlerContext ctx = client.getCtx();
        ctx.write(message);
    }

    /**
     * 发送信息
     * @param equipmentId
     * @param message
     */
    public static void sendMessage(String equipmentId, BaseMessage message){
        sendMessage(ClientContainer.getInstance().get(equipmentId), message);
    }

    /**
     * 群发信息
     * @param message
     */
    public static void sendMessage(List<Client> list, BaseMessage message){
        for(Client client : list){
            sendMessage(client, message);
        }
    }

    /**
     * 发送所有在线信息
     * @param message
     */
    public static void sendAllOL(BaseMessage message){
        if(message == null){
            return;
        }
        for(Client client : ClientContainer.getInstance().getALL()){
            sendMessage(client, message);
        }
    }
}
