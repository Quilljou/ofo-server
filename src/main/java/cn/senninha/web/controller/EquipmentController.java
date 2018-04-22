package cn.senninha.web.controller;

import cn.senninha.db.entity.EquipmentEntity;
import cn.senninha.web.consts.Project;
import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Project.API_PREFIX)
public class EquipmentController {
    private Logger logger = LoggerFactory.getLogger(EquipmentController.class);

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/stations/{stationId}/equipments")
    public Result selectByStationId(@PathVariable int stationId) throws BadReqeuestException{
        return equipmentService.selectByStationId(stationId);
    }

    @GetMapping("/stations/{stationId}/equipments/{equipmentId}")
    public Result selectOne(@PathVariable int stationId, @PathVariable int equipmentId) throws BadReqeuestException{
        return equipmentService.selectOne(stationId, equipmentId);
    }

    @PostMapping("/stations/{stationId}/equipments")
    public Result insert(@Valid @RequestBody EquipmentEntity equipmentEntity, BindingResult bindingResult,@PathVariable int stationId) throws BadReqeuestException{
        if(bindingResult.hasErrors()) {
            throw new BadReqeuestException(bindingResult.getFieldError().getDefaultMessage());
        }
        equipmentEntity.setStationId(stationId);
        return equipmentService.insert(equipmentEntity);
    }

    @PutMapping("/stations/{stationId}/equipments/{equipmentId}")
    public Result update(@Valid @RequestBody EquipmentEntity equipmentEntity, @PathVariable int stationId, @PathVariable int equipmentId) throws Exception{
        equipmentEntity.setStationId(stationId);
        equipmentEntity.setId(equipmentId);
        return equipmentService.update(equipmentEntity);
    }

}
