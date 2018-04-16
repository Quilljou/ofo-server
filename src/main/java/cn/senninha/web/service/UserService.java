package cn.senninha.web.service;

import cn.senninha.db.entity.UserEntity;
import cn.senninha.web.domain.Result;

public interface UserService {
    public Result selectAll();
    public Result selectOne(int id);
    public Result update(UserEntity user);
    public Result insert(UserEntity user);
    public Result delete(int id);
    public Result updateLastLoginTime(UserEntity user);
    public void initAdmin(UserEntity user);
    public UserEntity isInitedAdmin(int isRoot);
    public UserEntity selectByName(String name);
    public Result selectByWho(UserEntity user);
}
