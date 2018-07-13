package com.hub.hubback.service;

import com.hub.hubback.util.Result;

import java.util.Map;

public interface BlogMainService {
    Result saveBlog(Map<String,String> map);
    Result showBlog();
    Result showBlogById(String uuid);
    Result addReadCount(String uuid);
    Result addLikeCount(String uuid);
    Result getBlogUrlByType(String uuid);
}
