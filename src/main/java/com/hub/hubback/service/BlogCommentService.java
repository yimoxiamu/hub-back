package com.hub.hubback.service;

import com.hub.hubback.util.Result;

import java.util.Map;

public interface BlogCommentService {
    Result getCommentByUUID(String uuid);
    Result addComment(Map map);
}
