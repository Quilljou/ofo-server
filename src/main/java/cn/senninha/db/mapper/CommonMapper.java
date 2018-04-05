package cn.senninha.db.mapper;

import java.util.List;

/**
 * 增删改查接口
 * Coded by senninha on 18-1-20
 */
public interface CommonMapper<T> {
    public List<T> selectAll();
    public T selectOne(int id);
    public int update(T t);
    public int insert(T t);
    public int delete(int id);
}
