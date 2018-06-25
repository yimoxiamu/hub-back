package com.hub.hubback.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hub.hubback.entity.BlogTypeEntity;
import com.hub.hubback.service.BlogTypeService;
import com.hub.hubback.util.ResultUtil;
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
    public ResultUtil getAllType(){
        ResultUtil resultUtil=new ResultUtil();
        List<BlogTypeEntity> blogTypeEntities=blogTypeService.getAllType();
        resultUtil.setRetCode(0);
        resultUtil.setRetMsg(blogTypeEntities);
        return resultUtil;
    }
}
