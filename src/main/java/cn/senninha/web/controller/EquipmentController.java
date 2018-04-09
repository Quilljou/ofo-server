package cn.senninha.web.controller;

import cn.senninha.db.entity.EquipmentEntity;
import cn.senninha.web.consts.Project;
import cn.senninha.web.domain.Result;
import cn.senninha.web.service.EquipmentService;
import cn.senninha.web.service.impl.EquipmentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Project.API_PREFIX)
public class EquipmentController {
    private Logger logger = LoggerFactory.getLogger(EquipmentController.class);

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/stations/{stationId}/equipments")
    public Result selectByStationId(@PathVariable int stationId) {
        return equipmentService.selectByStationId(stationId);
    }

    @PostMapping("/stations/{stationId}/equipments")
    public Result insert(@Valid @RequestBody EquipmentEntity equipmentEntity, @PathVariable int stationId) {
        equipmentEntity.setStationId(stationId);
        return equipmentService.insert(equipmentEntity);
    }

    @PutMapping("/stations/{stationId}/equipments/{equipmentId}")
    public Result update(@Valid @RequestBody EquipmentEntity equipmentEntity, @PathVariable int stationId, @PathVariable int equipmentId) {
        equipmentEntity.setStationId(stationId);
        equipmentEntity.setId(equipmentId);
        return equipmentService.update(equipmentEntity);
    }

}
