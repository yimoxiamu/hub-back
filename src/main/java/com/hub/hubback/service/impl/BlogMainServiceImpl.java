package com.hub.hubback.service.impl;

import com.hub.hubback.dao.BlogMainMapper;
import com.hub.hubback.entity.BlogMainEntity;
import com.hub.hubback.exception.GlobalException;
import com.hub.hubback.service.BlogMainService;
import com.hub.hubback.util.CodeMsg;
import com.hub.hubback.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired(required = false)
    public BlogMainMapper blogMainMapper;


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
        return Result.success(list);
    }


}
