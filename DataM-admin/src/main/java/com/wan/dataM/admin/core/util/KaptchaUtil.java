package com.wan.dataM.admin.core.util;


import com.wan.dataM.admin.config.properties.DataMProperties;
import com.wan.dataM.core.util.SpringContextHolder;

/**
 * 验证码工具类
 */
public class KaptchaUtil {


    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(DataMProperties.class).getKaptchaOpen();
    }
}