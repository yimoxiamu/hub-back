package com.hub.hubback.exception;

import com.hub.hubback.util.CodeMsg;
import lombok.Data;

/**
 * @ClassName GlobalException
 * @Description 自定义异常类
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/7/3 13:44
 * @VERSION 1.0
 **/
@Data
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID=1l;
    private CodeMsg cm;
    public GlobalException(CodeMsg codeMsg){
        super(codeMsg.getMsg());
        this.cm=codeMsg;
    }

}
