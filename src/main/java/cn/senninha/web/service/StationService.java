package cn.senninha.web.service;

import cn.senninha.db.entity.StationEntity;
import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;

import java.util.List;

public interface StationService {
    public Result selectAll();
    public Result selectOne(int id);
    public Result update(StationEntity station);
    public Result insert(StationEntity station) throws BadReqeuestException;
    public Result delete(int id);
}
