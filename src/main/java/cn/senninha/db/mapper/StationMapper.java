package cn.senninha.db.mapper;

import cn.senninha.db.entity.StationEntity;
import cn.senninha.db.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StationMapper {
    @Select("SELECT * FROM station")
    List<StationEntity> selectAll();

    @Select("SELECT * FROM station WHERE id = #{id}")
    StationEntity selectOne(int id);

    @Insert("INSERT INTO station(name,location,station_id) VALUES(#{name}, #{location}, #{station_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(StationEntity station);

    @Update("UPDATE station SET name=#{name},location=#{location}, station_id=#{station_id} WHERE id =#{id}")
    void update(StationEntity station);

    @Delete("DELETE FROM station WHERE id =#{id}")
    void delete(int id);
}
