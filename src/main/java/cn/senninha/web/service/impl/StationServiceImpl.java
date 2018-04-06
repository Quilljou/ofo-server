package cn.senninha.web.service.impl;

import cn.senninha.db.entity.StationEntity;
import cn.senninha.db.mapper.StationDao;
import cn.senninha.web.domain.Result;
import cn.senninha.web.service.StationService;
import cn.senninha.web.util.resultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StationServiceImpl implements StationService{
    @Autowired
    private StationDao stationDao;

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
            throw new RuntimeException("更新充电站失败:" + e.getMessage());
        }
        StationEntity newStation = stationDao.selectOne(station.getId());
        return resultUtil.success(newStation);
    }

    @Override
    @Transactional
    public Result insert(StationEntity station) {
        try {
            stationDao.insert(station);
        } catch (Exception e) {
            throw new RuntimeException("创建充电站失败：" + e.getMessage());
        }
        StationEntity newStation = stationDao.selectOne(station.getId());
        return resultUtil.success(newStation);
    }

    @Override
    public Result delete(int id) {
        try {
            stationDao.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("删除充电站失败：" + e.getMessage());
        }
        return resultUtil.success(null);
    }
}
