package com.wan.dataM.core.util;

import com.alibaba.fastjson.JSON;
import com.wan.dataM.core.exception.BaseException;
import com.wan.dataM.core.exception.BaseExceptionEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 渲染工具类
 *
 */
public class RenderUtil {

    /**
     * 渲染json对象
     */
    public static void renderJson(HttpServletResponse response, Object jsonObject) {
        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(jsonObject));
        } catch (IOException e) {
            throw new BaseException(BaseExceptionEnum.WRITE_ERROR);
        }
    }
}
