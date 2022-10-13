package com.yxy.seckilldemo.exception;

import com.yxy.seckilldemo.vo.RespBean;
import com.yxy.seckilldemo.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全局异常
 */
public class GlobalException extends RuntimeException {

    private RespBeanEnum respBeanEnum;

    public RespBeanEnum getRespBeanEnum() {
        return respBeanEnum;
    }

    public void setRespBeanEnum(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }

    public GlobalException(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }
}
