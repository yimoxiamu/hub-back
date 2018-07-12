package com.hub.hubback.control;

import com.hub.hubback.entity.BlogMainEntity;
import com.hub.hubback.entity.BlogTypeEntity;
import com.hub.hubback.service.BlogMainService;
import com.hub.hubback.service.BlogTypeService;
import com.hub.hubback.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BlogTypeControl
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/6/25 17:05
 * @VERSION 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/type")
public class BlogTypeControl {
    @Autowired
    BlogTypeService blogTypeService;

    @RequestMapping("/defaultType")
    public Result getAllType(){

        return blogTypeService.getAllType();
    }

}
