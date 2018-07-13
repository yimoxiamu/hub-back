package com.hub.hubback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(value = "com.hub.hubback.dao")
@SpringBootApplication
@EnableScheduling
public class HubBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(HubBackApplication.class, args);
    }

}
