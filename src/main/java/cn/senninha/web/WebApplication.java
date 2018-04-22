package cn.senninha.web;

import cn.senninha.sserver.ServerStart;
import cn.senninha.web.config.ServerConfig;
import cn.senninha.web.controller.UserController;
import cn.senninha.web.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("cn.senninha.db.mapper")
public class WebApplication {
	public static void main(String[] args) {
//	    if(args.length >= 1){   //随便输入一个参数启动tcp服务器
//            ServerConfig.loadConfig();
//            ServerStart.startTcpServer();   //开启tcp服务器
//        }
        ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);
        UserController userCtrl = context.getBean(UserController.class);
        // 初始化系统用户
        userCtrl.initAdmin();
    }
}
