package cn.senninha.db.mapper;

import cn.senninha.db.entity.StationEntity;
import org.apache.ibatis.annotations.Param;

public interface StationDao extends CommonDao<StationEntity> {
    public int bindUser(@Param("stationId") int stationId,@Param("userId") int userId);
}
