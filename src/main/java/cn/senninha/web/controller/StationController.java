package cn.senninha.web.controller;

import cn.senninha.db.entity.StationEntity;
import cn.senninha.web.consts.Project;
import cn.senninha.web.domain.Result;
import cn.senninha.web.exception.BadReqeuestException;
import cn.senninha.web.service.StationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiresRoles("root")
@RequestMapping(Project.API_PREFIX)
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("/stations")
    public Result selectAll() {
        return stationService.selectAll();
    }

    @GetMapping("/stations/{id}")
    public Result getById(
            @PathVariable int id
    ) {
        return stationService.selectOne(id);
    }


/*
@DeleteMapping("/stations/{id}")
public Result delete(@PathVariable int id) {
return stationService.delete(id);
}
*/

    @PostMapping("/stations")
    public Result create(@Valid @RequestBody StationEntity station, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new BadReqeuestException(message);
        }
        return stationService.insert(station);
    }

    @PutMapping("/stations/{id}")
    public Result update(@PathVariable int id, @RequestBody StationEntity station) {
        station.setId(id);
        return stationService.update(station);
    }


    @PatchMapping("/stations/{stationId}/users/{userId}")
    public Result bindUser(@PathVariable int stationId, @PathVariable int userId) throws BadReqeuestException{
        return stationService.bindUser(stationId,userId);
    }
}
