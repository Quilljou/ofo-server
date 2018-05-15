package cn.senninha.web.service;

import cn.senninha.db.entity.UserEntity;
import cn.senninha.db.mapper.UserDao;
import cn.senninha.web.domain.Result;
import cn.senninha.web.util.resultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public Result selectAll() {
        List<UserEntity> users = userDao.selectAll();
        return resultUtil.success(users, null);
    }

    public Result selectOne(int id) {
        UserEntity userEntity = userDao.selectOne(id);
        return resultUtil.success(userEntity);
    }

    public Result update(UserEntity user) {
        try {
            userDao.update(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("更新用户失败");
        }
        UserEntity newUser = userDao.selectOne(user.getId());
        newUser.setPassword(null);
        return resultUtil.success(newUser);
    }

    public Result insert(UserEntity station) {

        userDao.insert(station);
        UserEntity newStation = userDao.selectOne(station.getId());
        return resultUtil.success(newStation);
    }

    public Result delete(int id) {
        try {
            userDao.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("删除充电站失败");
        }
        return resultUtil.success(null);
    }

    public Result updateLastLoginTime(UserEntity userEntity) {
        userDao.updateLastLoginTime(userEntity);
        return resultUtil.success(null);
    }

    public UserEntity selectByName(String username) {
        return userDao.selectByName(username);
    }
}

