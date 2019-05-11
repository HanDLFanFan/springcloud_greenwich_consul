package com.hdl.up_server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//开启服务注册和发现功能，将本实例注册到注册中心
@EnableDiscoveryClient
//此服务为其它服务提供基础服务
@RestController
//开启consul配置自动刷新
@RefreshScope
public class UpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpServerApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Value("${name}")
    String name;

    @RequestMapping("/action")
    public String action(){
        return "hello,I is base server and my port is "+ port;
    }

    @RequestMapping("/name")
    public String name(){
        return "name="+name;
    }

    /**
     * 测试  配合vue axios
     * @return
     */
    @RequestMapping("/action2")
    public User action2(){
        User user = new User();
        user.setInfo("hello,I is base server and my port is "+ port);
        return user;
    }

    @RequestMapping("/python")
    public String python(String s){
        if (s == null){
            System.out.println("null----");
        }else
            System.out.println("python_data==="+s);
        return "ok";
    }
}
