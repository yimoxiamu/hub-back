package com.hub.hubback.service;

import com.hub.hubback.entity.BlogTypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogTypeService {
    List<BlogTypeEntity> getAllType();
}
