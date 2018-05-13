package cn.senninha.web.service;

import cn.senninha.db.entity.EquipmentEntity;
import cn.senninha.db.mapper.EquipmentDao;
import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.util.resultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipmentService {
    private Logger logger = LoggerFactory.getLogger(EquipmentService.class);

    @Autowired
    private EquipmentDao equipmentDao;


    public Result selectByStationId(int stationId) throws BadReqeuestException{
        List<EquipmentEntity> equipmentEntityList = equipmentDao.selectByStationId(stationId);
        return resultUtil.success(equipmentEntityList);
    }

    public Result selectOne(int stationId, int equipmentId) {
        return resultUtil.success(equipmentDao.selectOne(equipmentId));
    }

    public Result update(EquipmentEntity equipmentEntity) throws Exception{
        // TODO: 2018/4/22 去除重复代码，改进 aspect
        int stationId = equipmentEntity.getStationId();
        String equipmentCode = equipmentEntity.getEquipmentCode();
        if(equipmentDao.selectByStationIdAndEquipmentCode(stationId, equipmentCode) != null) {
            throw new BadReqeuestException("充电桩编码重复");
        }
        try {
            equipmentDao.update(equipmentEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Error("更新充电站失败");
        }
        return resultUtil.success(equipmentEntity);
    }

    public Result insert(EquipmentEntity equipmentEntity) throws BadReqeuestException{
        // 查询该编码在该站下是否重复了
        int stationId = equipmentEntity.getStationId();
        String equipmentCode = equipmentEntity.getEquipmentCode();
        if(equipmentDao.selectByStationIdAndEquipmentCode(stationId, equipmentCode) != null) {
            throw new BadReqeuestException("充电桩编码重复");
        }

        try {
            equipmentDao.insert(equipmentEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("创建充电站失败");
        }
        return resultUtil.success(equipmentEntity);
    }

}
