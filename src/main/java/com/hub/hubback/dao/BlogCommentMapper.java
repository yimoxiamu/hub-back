package com.hub.hubback.dao;

import com.hub.hubback.entity.BlogCommentEntity;

import java.util.List;
import java.util.Map;

public interface BlogCommentMapper {
    List<BlogCommentEntity> getCommentByUUID(String uuid);
    void addComment(Map map);
    List<BlogCommentEntity> getCommentByParentId(String parentid);
}
