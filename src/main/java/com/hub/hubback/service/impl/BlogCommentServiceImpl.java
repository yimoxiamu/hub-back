package com.hub.hubback.service.impl;

import com.hub.hubback.dao.BlogCommentMapper;
import com.hub.hubback.entity.BlogCommentEntity;
import com.hub.hubback.service.BlogCommentService;
import com.hub.hubback.util.CodeMsg;
import com.hub.hubback.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BlogCommentServiceImpl
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/7/17 15:16
 * @VERSION 1.0
 **/
@Service
@Slf4j
public class BlogCommentServiceImpl implements BlogCommentService {

    @Autowired(required = false)
    private BlogCommentMapper blogCommentMapper;

    @Override
    public Result getCommentByUUID(String uuid) {
        List<BlogCommentEntity> list=new ArrayList<>();
        try {
            list= blogCommentMapper.getCommentByUUID(uuid);
        }catch (Exception e){
            log.info(e.getMessage());
            return new Result(CodeMsg.DB_ERROR);
        }

        List newList=new ArrayList();
        for (BlogCommentEntity blog: list) {
            Map<String,Object> maps=new HashMap<>();
            maps.put("blogFather",blog);
            List<BlogCommentEntity> sonList=blogCommentMapper.getCommentByParentId(String.valueOf(blog.getId()));
            if(sonList.size()>0){
                maps.put("blogSun",sonList);
            }
            newList.add(maps);
        }
        return Result.success(newList);
    }

    @Override
    public Result addComment(Map map) {
        try {
            blogCommentMapper.addComment(map);
        }catch (Exception e){
            log.info(e.getMessage());
            return new Result(CodeMsg.DB_ERROR);
        }
        return Result.success("success");
    }
}
