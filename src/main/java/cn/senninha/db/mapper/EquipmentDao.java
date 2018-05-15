package cn.senninha.db.mapper;

import cn.senninha.db.entity.EquipmentEntity;
import cn.senninha.db.entity.EquipmentStationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentDao extends CommonDao<EquipmentEntity>{
    public List<EquipmentEntity> selectByStationId(int staionId);
    public EquipmentEntity selectByStationIdAndEquipmentCode(@Param("stationId") int stationId,@Param("equipmentCode") String equipmentCode);
    public EquipmentStationEntity selectDetail(int staionId);
}
