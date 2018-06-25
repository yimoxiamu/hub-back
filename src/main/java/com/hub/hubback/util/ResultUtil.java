package com.hub.hubback.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @ClassName ResualtUtil
 * @Description TODO
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/6/25 17:07
 * @VERSION 1.0
 **/
@Data
public class ResultUtil {
    private JSONArray retMsg;                      //返回码
    private int retCode;                        //返回实体

    public  void  setRetMsg(Object retMsg) {
        String jsonStr=JSON.toJSONString(retMsg);
        JSONArray objects=JSONArray.parseArray(jsonStr);
        this.retMsg = objects;
    }
}