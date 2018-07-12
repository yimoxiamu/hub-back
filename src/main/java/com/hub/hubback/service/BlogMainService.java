package com.hub.hubback.service;

import com.hub.hubback.util.Result;

import java.util.Map;

public interface BlogMainService {
    Result saveBlog(Map<String,String> map);
    Result showBlog();
    Result showBlogById(String id);
    Result addReadCount(String id);
    Result addLikeCount(String id);
}
