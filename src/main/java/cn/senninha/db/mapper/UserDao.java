package cn.senninha.db.mapper;
import cn.senninha.db.entity.UserEntity;
import cn.senninha.web.domain.Result;

import java.util.List;

public interface UserDao extends CommonDao<UserEntity> {
    public int updateLastLoginTime(UserEntity userEntity);
    public int initAdmin(UserEntity userEntity);
    public UserEntity isInitedAdmin(int isRoot);
    public UserEntity selectByName(String username);
    public List<UserEntity> selectById(int id);

}