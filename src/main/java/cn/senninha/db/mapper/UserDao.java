package cn.senninha.db.mapper;
import cn.senninha.db.entity.UserEntity;

import java.util.List;

public interface UserDao extends CommonDao<UserEntity> {
    public int updateLastLoginTime(UserEntity userEntity);
    public UserEntity selectByName(String username);
}