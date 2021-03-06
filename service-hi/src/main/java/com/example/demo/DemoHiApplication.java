package com.example.demo;

import io.jboot.components.limiter.annotation.EnableLimit;
import io.jboot.web.controller.JbootController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhagsaiqiang
 * @date 2018/9/30 15:24
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoHiApplication extends JbootController {

    public static void main(String[] args) {
        SpringApplication.run(DemoHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;


    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        System.out.println("port111111222221:"+port);
        return "hi " + name + " ,i am from port:" + port;
    }
    @EnableLimit(rate = 1,fallback = "fallbackMethod")
    public void index(){
        renderText("hello world");
    }



}
