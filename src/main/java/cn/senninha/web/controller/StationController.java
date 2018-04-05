package cn.senninha.web.controller;

import cn.senninha.db.entity.StationEntity;
import cn.senninha.db.mapper.StationMapper;
import cn.senninha.web.domain.Result;
import cn.senninha.web.util.resultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StationController {
    @Autowired
    private StationMapper stationMapper;

    @GetMapping("/stations")
    public Result get() {
        List<StationEntity> stations = stationMapper.selectAll();
        return resultUtil.success(stations, null);
    }

    @DeleteMapping("/stations/{id}")
    public Result delete(@PathVariable int id) {
        stationMapper.delete(id);
        return resultUtil.success(null);
    }

    @PostMapping("/stations")
    public Result create(@RequestBody StationEntity station) {
        stationMapper.create(station);
        StationEntity newStation = stationMapper.selectOne(station.getId());
        return resultUtil.success(newStation);
    }

    @PutMapping("/stations/{id}")
    public Result update(@PathVariable int id, @RequestBody StationEntity station) {
        station.setId(id);
        stationMapper.update(station);
        StationEntity newStation = stationMapper.selectOne(station.getId());
        return resultUtil.success(newStation);
    }
}
