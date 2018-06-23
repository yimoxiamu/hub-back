package com.hub.hubback.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsTestControl {

    @RequestMapping("/test")
    public String corsTest(String name){
        System.out.printf(name);
        return name;
    }
}
