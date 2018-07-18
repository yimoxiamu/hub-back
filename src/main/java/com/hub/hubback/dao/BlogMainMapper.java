package com.hub.hubback.dao;

import com.hub.hubback.entity.BlogMainEntity;

import java.util.List;
import java.util.Map;

public interface BlogMainMapper {
    List<BlogMainEntity> getAllBlog();
    void saveBlog(Map map);
    BlogMainEntity showBlogByUUID(String id);
    void addReadCount(String id);
    void addLikeCount(String id);
    void updateBlog(BlogMainEntity blogMainEntity);
    List<BlogMainEntity> getBlogUrlByType(String uuid);
    List<BlogMainEntity> showBlogByType(String type);
    List<BlogMainEntity> getBlogByStatus(String status);
    List<BlogMainEntity> showBlogByFenYe(Map map);
    List<BlogMainEntity> showBlogByFenYeAndType(Map map);
}
