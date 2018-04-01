package cn.senninha.web;

import cn.senninha.db.DbManager;
import cn.senninha.db.dao.TestDao;
import cn.senninha.db.entity.Test;
import cn.senninha.equipment.container.ClientContainer;
import cn.senninha.equipment.container.PushHelper;
import cn.senninha.equipment.container.client.Client;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * browser--> web -->db --> tcp --> remote tcpClient
 * Coded by senninha on 18-1-22
 */
@Controller
@ResponseBody
public class SenninhaController {
  @GetMapping(value = "/")
    public static final String index() {
      return "hello world";
  }

}
