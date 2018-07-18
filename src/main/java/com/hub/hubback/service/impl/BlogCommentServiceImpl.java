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
        return Result.success(list);
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
