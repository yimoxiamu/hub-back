package com.hub.hubback.entity;

import lombok.Data;
/**
 * @ClassName BlogTypeEntity
 * @Description TODO
 * @Author  xiamu
 * @Email 768840822@qq.com
 * @Date 2018/6/25 15:45
 * @VERSION 1.0
 **/
@Data
public class BlogTypeEntity {
    private int id;                                               //id
    private String blog_type;                                     //博文类型
    private int   count;                                          //此类型博文数量
}
