package com.hub.hubback.control;

import com.hub.hubback.service.BlogMainService;
import com.hub.hubback.util.DateUtil;
import com.hub.hubback.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    StringRedisTemplate template;

    @Autowired
    BlogMainService blogMainService;

    @RequestMapping("/saveblog")
    public Result saveBlog(String text, String title, String description, String blogType,String status,String titleImg){
        Map<String,String> map=new HashMap<>();
        String uuid=UUID.randomUUID().toString().replaceAll("-","");
        map.put("text",text);
        map.put("title",title);
        map.put("status",status);
        map.put("description",description);
        map.put("blogType",blogType);
        map.put("insertTime",DateUtil.dataFormate(new Date()));
        map.put("blog_uuid",uuid);
        map.put("blog_info_url","info.html?"+uuid);
        map.put("blog_title_img",titleImg);
        return blogMainService.saveBlog(map);
    }

    @RequestMapping(value = "/updateBlog")
    public Result update(String text,String title){
        Map map=new HashMap();
        map.put("text",text);
        map.put("title",title);
        return blogMainService.updateBlog(map);
    }

    @RequestMapping(value = "/showAllBlog")
    public Result showAllBlog(String type){
        if(type.equals("m")){
            return blogMainService.showBlog();
        }else{
            return blogMainService.showBlogByType(type);
        }
    }

    @RequestMapping(value = "/showBlogFenYe")
    public Result showBlogByFenYe(String type,String num){
        int Num=Integer.valueOf(num);
        Map map=new HashMap();
        map.put("type",type);
        map.put("num",(Num-1)*8);
        map.put("size",8);
        return blogMainService.getBlogByFenYe(map);
    }


    @RequestMapping(value = "/showOneBlog")
    public Result showOneBlog(String id){
        return blogMainService.showBlogById(id);
    }

    @RequestMapping(value = "/addReadCount")
    public Result addReadCount(String id){
        return blogMainService.addReadCount(id);
    }

    @RequestMapping(value = "/addLikeCount")
    public Result addLikeCount(String id){
        return blogMainService.addLikeCount(id);
    }

    @RequestMapping(value = "/getBlogByType")
    public Result getBlogByType(String id){
        return blogMainService.getBlogUrlByType(id);
    }

    @RequestMapping(value = "/getBlogByStatus")
    public Result getBlogByStatus(String status){
        return blogMainService.getBlogbyStatus(status);
    }

}
