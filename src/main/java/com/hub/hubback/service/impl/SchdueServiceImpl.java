package com.hub.hubback.service.impl;

import com.alibaba.fastjson.JSON;
import com.hub.hubback.dao.BlogMainMapper;
import com.hub.hubback.entity.BlogMainEntity;
import com.hub.hubback.service.SchdueService;
import com.hub.hubback.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName SchdueServiceImpl
 * @Description 定时任务service
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/7/13 9:31
 * @VERSION 1.0
 **/
@Component
@Slf4j
public class SchdueServiceImpl implements SchdueService {

    @Autowired
    StringRedisTemplate template;

    @Autowired(required = false)
    BlogMainMapper blogMainMapper;

    @Scheduled(cron = "0 0/1 * * * ?")
    @Override
    public void DataSynchronism() {
        List<BlogMainEntity> list=blogMainMapper.getAllBlog();
        RedisUtil.DataSynchronism(list, template);
        log.info("数据存入缓存成功，成功存入缓存 "+list.size()+" 条");
    }


}
