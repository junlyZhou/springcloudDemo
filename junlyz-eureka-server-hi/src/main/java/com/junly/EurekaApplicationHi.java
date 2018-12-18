package com.junly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaApplication
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/15 0015 20:30
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class EurekaApplicationHi {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationHi.class, args);
    }
}
