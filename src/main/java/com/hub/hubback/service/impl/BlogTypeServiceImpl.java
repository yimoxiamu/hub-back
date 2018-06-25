package com.hub.hubback.service.impl;

import com.hub.hubback.dao.BlogTypeMapper;
import com.hub.hubback.entity.BlogTypeEntity;
import com.hub.hubback.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BlogTypeServiceImpl
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/6/25 16:35
 * @VERSION 1.0
 **/
@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired(required = false)
    private BlogTypeMapper blogTypeMapper;

    @Override
    public List<BlogTypeEntity> getAllType() {
        return blogTypeMapper.getAllType();
    }
}
