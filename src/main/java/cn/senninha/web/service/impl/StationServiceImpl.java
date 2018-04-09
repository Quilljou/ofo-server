package cn.senninha.web.service.impl;

import cn.senninha.db.entity.StationEntity;
import cn.senninha.db.mapper.StationDao;
import cn.senninha.web.domain.Result;
import cn.senninha.web.service.StationService;
import cn.senninha.web.util.resultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class StationServiceImpl implements StationService{
    private Logger logger = LoggerFactory.getLogger(StationServiceImpl.class);

    @Autowired
    private StationDao stationDao;
    // TODO: 08/04/2018 超级管理员返回站列表，普通管理员返回所在站的信息，统一列表返回
    @Override
    public Result selectAll() {
        List<StationEntity> stations = stationDao.selectAll();
        return resultUtil.success(stations, null);
    }

    @Override
    public Result selectOne(int id) {
        StationEntity stationEntity = stationDao.selectOne(id);
        return resultUtil.success(stationEntity);
    }

    @Override
    @Transactional
    public Result update(StationEntity station) {
        try {
            stationDao.update(station);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("更新充电站失败");
        }
        StationEntity newStation = stationDao.selectOne(station.getId());
        return resultUtil.success(newStation);
    }

    @Override
    @Transactional
    public Result insert(StationEntity station) {
        try {
            stationDao.insert(station);
        } catch (DuplicateKeyException e) {

            throw new RuntimeException("充电站编码重复");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("创建充电站失败");
        }
        StationEntity newStation = stationDao.selectOne(station.getId());
        return resultUtil.success(newStation);
    }

    @Override
    public Result delete(int id) {
        try {
            stationDao.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("删除充电站失败：");
        }
        return resultUtil.success(null);
    }
}
