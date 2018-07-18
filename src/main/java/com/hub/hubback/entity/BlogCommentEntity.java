package com.hub.hubback.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName BlogCommentEntity
 * @Description 评论实体类
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/7/17 15:11
 * @VERSION 1.0
 **/
@Data
public class BlogCommentEntity {
    private int id;
    private String blog_comment;
    private String blog_uuid;
    private Date pull_time;
}
