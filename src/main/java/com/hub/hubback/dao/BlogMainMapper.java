package com.hub.hubback.dao;

import com.hub.hubback.entity.BlogMainEntity;

import java.util.List;
import java.util.Map;

public interface BlogMainMapper {
    List<BlogMainEntity> getAllBlog();
    void saveBlog(Map map);
}
