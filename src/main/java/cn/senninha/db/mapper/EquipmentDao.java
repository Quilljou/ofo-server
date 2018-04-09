package cn.senninha.db.mapper;

import cn.senninha.db.entity.EquipmentEntity;

import java.util.List;

public interface EquipmentDao extends CommonDao<EquipmentEntity>{
    public List<EquipmentEntity> selectByStationId(int staionId);
}
