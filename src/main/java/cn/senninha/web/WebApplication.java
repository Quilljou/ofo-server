package cn.senninha.web;

import cn.senninha.sserver.ServerStart;
import cn.senninha.web.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
//	    if(args.length >= 1){   //随便输入一个参数启动tcp服务器
//            ServerConfig.loadConfig();
//            ServerStart.startTcpServer();   //开启tcp服务器
//        }
        SpringApplication.run(WebApplication.class, args);
    }
}
