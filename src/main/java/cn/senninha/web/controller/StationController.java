package cn.senninha.web.controller;

import cn.senninha.db.entity.StationEntity;
import cn.senninha.db.mapper.StationDao;
import cn.senninha.web.domain.Result;
import cn.senninha.web.service.StationService;
import cn.senninha.web.util.resultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("/stations")
    public Result get() {
        return stationService.selectAll();
    }

    @DeleteMapping("/stations/{id}")
    public Result delete(@PathVariable int id) {
        return stationService.delete(id);
    }

    @PostMapping("/stations")
    public Result create(@Valid @RequestBody StationEntity station, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new Exception(message);
        }
        return stationService.insert(station);
    }

    @PutMapping("/stations/{id}")
    public Result update(@PathVariable int id, @RequestBody StationEntity station) {
        station.setId(id);
        return stationService.update(station);
    }
}
