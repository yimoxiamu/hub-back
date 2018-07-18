package com.hub.hubback.control;

import com.hub.hubback.service.BlogCommentService;
import com.hub.hubback.util.DateUtil;
import com.hub.hubback.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BlogCommentControl
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/7/17 15:17
 * @VERSION 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/comment")
public class BlogCommentControl {

    @Autowired
    private BlogCommentService blogCommentService;

    @RequestMapping(value = "/getCommentByUUID")
    public Result getCommentByUUID(String uuid){
        return blogCommentService.getCommentByUUID(uuid);
    }

    @RequestMapping(value = "/addComment")
    public Result addComment(String comment, String uuid){
        Map map=new HashMap();
        map.put("blog_comment",comment);
        map.put("blog_uuid",uuid);
        map.put("pull_time",DateUtil.dataFormate(new Date()));
        return blogCommentService.addComment(map);
    }

}
