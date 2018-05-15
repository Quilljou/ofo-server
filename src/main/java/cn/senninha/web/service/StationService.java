package cn.senninha.web.service;

import cn.senninha.db.entity.StationEntity;
import cn.senninha.db.entity.UserEntity;
import cn.senninha.db.mapper.StationDao;
import cn.senninha.db.mapper.UserDao;
import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.util.resultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    private Logger logger = LoggerFactory.getLogger(StationService.class);

    @Autowired
    private StationDao stationDao;
    @Autowired UserDao userDao;
    public Result selectAll() {
        List<StationEntity> stations = stationDao.selectAll();
        return resultUtil.success(stations, null);
    }

    public Result selectOne(int id) {
        StationEntity stationEntity = stationDao.selectOne(id);
        return resultUtil.success(stationEntity);
    }

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

    public Result insert(StationEntity station) throws BadReqeuestException {
        try {
            stationDao.insert(station);
        } catch (DuplicateKeyException e) {
            throw new BadReqeuestException("充电站编码重复");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("创建充电站失败");
        }
        StationEntity newStation = stationDao.selectOne(station.getId());
        return resultUtil.success(newStation);
    }

    @Deprecated
    public Result delete(int id) {
        try {
            stationDao.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("删除充电站失败：");
        }
        return resultUtil.success(null);
    }

    public Boolean isStationExisted(int stationId) {
        StationEntity stationEntity = stationDao.selectOne(stationId);
        return stationEntity != null;
    }

    public Result bindUser(int stationId, int userId) throws BadReqeuestException{
        UserEntity userEntity = userDao.selectOne(userId);
        if(userEntity == null) {
            throw new BadReqeuestException("该用户不存在");
        }
        if(isStationExisted(stationId) == false) {
            throw new BadReqeuestException("该充电站不存在");
        }
        try {
            stationDao.bindUser(stationId, userId);
            return resultUtil.success(null);
        }catch (Exception e) {
            throw new RuntimeException("充电站绑定用户失败");
        }
    }
}
