package com.hub.hubback.util;

import com.alibaba.fastjson.JSON;
import com.hub.hubback.entity.BlogMainEntity;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * @ClassName RedisUtil
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/7/13 9:52
 * @VERSION 1.0
 **/
public class RedisUtil {
    /**
     * 数据存入缓存
     * @param list
     * @param template
     */
    public static void DataSynchronism(List<BlogMainEntity> list, StringRedisTemplate template) {
        for (BlogMainEntity blogMainEntity:list) {
            String jsonStr= JSON.toJSONString(blogMainEntity);
            if(!template.hasKey(blogMainEntity.getBlog_uuid())){
                template.opsForValue().append(blogMainEntity.getBlog_uuid(), jsonStr);
            }else{
                template.delete(blogMainEntity.getBlog_uuid());
                template.opsForValue().append(blogMainEntity.getBlog_uuid(), jsonStr);
            }
        }
    }
}
