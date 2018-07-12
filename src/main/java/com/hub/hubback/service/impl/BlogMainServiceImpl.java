package com.hub.hubback.service.impl;

import com.alibaba.fastjson.JSON;
import com.hub.hubback.dao.BlogMainMapper;
import com.hub.hubback.entity.BlogMainEntity;
import com.hub.hubback.service.BlogMainService;
import com.hub.hubback.util.CodeMsg;
import com.hub.hubback.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BlogMainServiceImpl
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/6/25 16:35
 * @VERSION 1.0
 **/
@Slf4j
@Service
public class BlogMainServiceImpl implements BlogMainService {

    @Autowired
    StringRedisTemplate template;

    @Autowired(required = false)
    public BlogMainMapper blogMainMapper;

    private String now_uuid;
    private String now_title;
    private String last_blog_uuid;
    private String last_blog_title;
    private String next_blog_uuid;
    private String next_blog_title;

    @Override
    public Result saveBlog(Map<String, String> map) {
        try {
            blogMainMapper.saveBlog(map);
        }catch (Exception e){
            log.info(e.getMessage());
            return new Result(CodeMsg.DB_ERROR);
        }
        return Result.success("success");
    }

    @Override
    public Result showBlog() {
        List<BlogMainEntity> list=new ArrayList();
        try {
             list=blogMainMapper.getAllBlog();
        }catch (Exception e){
            log.info(e.getMessage());
            return new Result(CodeMsg.DB_ERROR);
        }

        //处理
        for (int i = 0; i <list.size(); i++) {
            if(i!=list.size()-1){
                next_blog_title=list.get(i+1).getBlog_title();
                next_blog_uuid="info.html?"+list.get(i+1).getBlog_uuid();
            }
            if(i!=0){
                last_blog_title=list.get(i-1).getBlog_title();
                last_blog_uuid="info.html?"+list.get(i-1).getBlog_uuid();
            }
            if(i==0){
                list.get(i).setLast_blog_title("无");
                list.get(i).setLast_blog_uuid("0000");
                list.get(i).setNext_blog_title(next_blog_title);
                list.get(i).setNext_blog_uuid(next_blog_uuid);
            }
            if(i==list.size()-1){
                list.get(i).setNext_blog_title("无");
                list.get(i).setNext_blog_uuid("0000");
                list.get(i).setLast_blog_title(last_blog_title);
                list.get(i).setLast_blog_uuid(last_blog_uuid);
            }
            if(i!=0&&i!=list.size()-1){
                list.get(i).setNext_blog_title(next_blog_title);
                list.get(i).setNext_blog_uuid(next_blog_uuid);
                list.get(i).setLast_blog_title(last_blog_title);
                list.get(i).setLast_blog_uuid(last_blog_uuid);
            }
        }

        //存缓存
        for (BlogMainEntity blogMainEntity:list) {
            String jsonStr=JSON.toJSONString(blogMainEntity);
            if(!template.hasKey(blogMainEntity.getBlog_uuid())){
                template.opsForValue().append(blogMainEntity.getBlog_uuid(), jsonStr);
            }else{
                template.delete(blogMainEntity.getBlog_uuid());
                template.opsForValue().append(blogMainEntity.getBlog_uuid(), jsonStr);
            }
        }
        return Result.success(list);
    }

    @Override
    public Result showBlogById(String id) {
        if(template.hasKey(id)){
            BlogMainEntity blogMainEntity=JSON.parseObject(template.opsForValue().get(id),BlogMainEntity.class);
            return Result.success(blogMainEntity);
        }
        BlogMainEntity blogMainEntity=new BlogMainEntity();
        try {
            blogMainEntity=blogMainMapper.showBlogByUUID(id);
        }catch (Exception e){
            log.info(e.getMessage());
            return new Result(CodeMsg.DB_ERROR);
        }
        return Result.success(blogMainEntity);
    }

    @Override
    public Result addReadCount(String id) {
        try {
            blogMainMapper.addReadCount(id);
        }catch (Exception e){
            log.info(e.getMessage());
            return new Result(CodeMsg.DB_ERROR);
        }
        return Result.success("success");
    }

    @Override
    public Result addLikeCount(String id) {
        try {
            blogMainMapper.addLikeCount(id);
        }catch (Exception e){
            log.info(e.getMessage());
            return new Result(CodeMsg.DB_ERROR);
        }
        return Result.success("success");
    }


}
