package com.hub.hubback.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @ClassName ResualtUtil
 * @Description 返回实体类
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/7/03 14:03
 * @VERSION 1.1
 **/
@Data
public class Result<T> {
    private int code;       // ex 0000
    private String msg;     // ex success
    private T data;       // 返回实体

    public  static  <T> Result<T> success(T data){
        return new Result<T>(0000,"success",data);
    }

    public static <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }


    public Result(CodeMsg codeMsg){
        if(codeMsg!=null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }


    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}