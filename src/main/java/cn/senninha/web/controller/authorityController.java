package cn.senninha.web.controller;

import cn.senninha.db.DbManager;
import cn.senninha.db.dao.TestDao;
import cn.senninha.db.entity.Test;
import cn.senninha.web.domain.Result;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class authorityController {
    @GetMapping(value = "/login")
    public Result root(){
        Result res = new Result();

        return res;
    }



}

