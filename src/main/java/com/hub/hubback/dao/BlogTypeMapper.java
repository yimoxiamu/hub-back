package com.hub.hubback.dao;

import com.hub.hubback.entity.BlogTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogTypeMapper {
    List<BlogTypeEntity> getAllType();
    void addType(String type);
}
