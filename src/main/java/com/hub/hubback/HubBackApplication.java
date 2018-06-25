package com.hub.hubback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.hub.hubback.dao")
@SpringBootApplication
public class HubBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(HubBackApplication.class, args);
    }

}
