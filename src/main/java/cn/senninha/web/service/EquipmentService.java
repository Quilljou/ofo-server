package cn.senninha.web.service;

import cn.senninha.db.entity.EquipmentEntity;
import cn.senninha.web.domain.Result;

public interface EquipmentService {
    public Result selectByStationId(int station_code);
    public Result selectOne(int id);
    public Result update(EquipmentEntity equipmentEntity);
    public Result insert(EquipmentEntity equipmentEntity);
}
