package com.hub.hubback.entity;

import lombok.Data;

import java.sql.Struct;
import java.util.Date;

/**
 * @ClassName BlogMainEntity
 * @Description TODO
 * @Author  xiamu
 * @Email 768840822@qq.com
 * @Date 2018/6/25 15:45
 * @VERSION 1.0
 **/
@Data
public class BlogMainEntity {
    private int id;
    private BlogTypeEntity blogTypeEntity;
    private String blog_title;
    private String blog_text;
    private String blog_title_img;
    private Date insert_time;
    private Date update_time;
    private int read_count;
    private int like_count;
    private String blog_auth;
    private String blog_description;
    private String blog_info_url;
    private String blog_uuid;
    private String last_blog_uuid;
    private String last_blog_title;
    private String next_blog_uuid;
    private String next_blog_title;
    private String blog_status;
}
