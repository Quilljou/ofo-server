package cn.senninha.equipment.message.req;

import cn.senninha.equipment.message.CmdConstant;
import cn.senninha.sserver.lang.codec.field.Field32Bytes;
import cn.senninha.sserver.lang.message.BaseMessage;
import cn.senninha.sserver.lang.message.Message;

@Message(cmd = CmdConstant.REQ_HEARTBEAT)
public class ReqHearbeat extends BaseMessage{
    private short blank0;
    private Field32Bytes equipmentId;
    private short heartIndex;

    public short getBlank0() {
        return blank0;
    }

    public void setBlank0(short blank0) {
        this.blank0 = blank0;
    }

    public Field32Bytes getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Field32Bytes equipmentId) {
        this.equipmentId = equipmentId;
    }

    public short getHeartIndex() {
        return heartIndex;
    }

    public void setHeartIndex(short heartIndex) {
        this.heartIndex = heartIndex;
    }

    @Override
    public String toString() {
        return "ReqHearbeat{" +
                "blank0=" + blank0 +
                ", equipmentId=" + equipmentId +
                ", heartIndex=" + heartIndex +
                "} " + super.toString();
    }
}
