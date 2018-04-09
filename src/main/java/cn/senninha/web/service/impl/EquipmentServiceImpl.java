package cn.senninha.web.service.impl;

import cn.senninha.db.entity.EquipmentEntity;
import cn.senninha.db.entity.StationEntity;
import cn.senninha.db.mapper.EquipmentDao;
import cn.senninha.sserver.handler.DispatchHandler;
import cn.senninha.web.domain.Result;
import cn.senninha.web.service.EquipmentService;
import cn.senninha.web.util.resultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService{
    private Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class);

    @Autowired
    private EquipmentDao equipmentDao;
    @Override
    public Result selectByStationId(int station_id) {
        List<EquipmentEntity> equipmentEntityList = equipmentDao.selectByStationId(station_id);
        return resultUtil.success(equipmentEntityList);
    }

    @Override
    public Result selectOne(int id) {
        return resultUtil.success(equipmentDao.selectOne(id));
    }

    @Override
    public Result update(EquipmentEntity equipmentEntity) {
        try {
            equipmentDao.update(equipmentEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Error("更新充电站失败");
        }
        return selectOne(equipmentEntity.getId());
    }

    @Transactional
    @Override
    public Result insert(EquipmentEntity equipmentEntity) {
        // TODO: 2018/4/8 检查 staionId 是否存在  外键 ？
        try {
            equipmentDao.insert(equipmentEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("创建充电站失败");
        }
        return resultUtil.success(equipmentEntity);
    }

}
