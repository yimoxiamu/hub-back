package com.hub.hubback.control;

import com.hub.hubback.service.BlogMainService;
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
 * @ClassName BlogMainControl
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/7/11 14:37
 * @VERSION 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/main")
public class BlogMainControl {
    @Autowired
    BlogMainService blogMainService;

    @RequestMapping("/saveblog")
    public Result saveBlog(String text, String title, String description, String blogType){
        Map<String,String> map=new HashMap();
        map.put("text",text);
        map.put("title",title);
        map.put("description",description);
        map.put("blogType",blogType);
        map.put("insertTime",DateUtil.dataFormate(new Date()));
        map.put("blog_info_url","info.html?"+title);
        return blogMainService.saveBlog(map);
    }

    @RequestMapping(value = "/showAllBlog")
    public Result showAllBlog(){
        return blogMainService.showBlog();
    }

    @RequestMapping(value = "/showOneBlog")
    public Result showOneBlog(String id){
        return blogMainService.showBlogById(id);
    }

    @RequestMapping(value = "/addReadCount")
    public Result addReadCount(String id){
        return blogMainService.addReadCount(id);
    }
}
