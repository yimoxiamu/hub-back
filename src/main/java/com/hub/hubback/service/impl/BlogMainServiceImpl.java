package com.hub.hubback.service.impl;

import com.hub.hubback.dao.BlogMainMapper;
import com.hub.hubback.entity.BlogMainEntity;
import com.hub.hubback.exception.GlobalException;
import com.hub.hubback.service.BlogMainService;
import com.hub.hubback.util.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BlogMainServiceImpl
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/6/25 16:35
 * @VERSION 1.0
 **/
@Service
public class BlogMainServiceImpl implements BlogMainService {

    @Autowired(required = false)
    public BlogMainMapper blogMainMapper;

    @Override
    public List<BlogMainEntity> test() {
        List<BlogMainEntity> blogMainEntities=blogMainMapper.test();
        return blogMainEntities;
    }

    @Override
    public String errorTest(String str) {
        if(str=="12345"||str.equals("12345")){
            throw new GlobalException(CodeMsg.MOBILE_EMPTY);
        }
        return str;
    }

}
