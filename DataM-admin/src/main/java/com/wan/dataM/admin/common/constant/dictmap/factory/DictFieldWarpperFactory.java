package com.wan.dataM.admin.common.constant.dictmap.factory;


import com.wan.dataM.admin.common.constant.factory.ConstantFactory;
import com.wan.dataM.admin.common.constant.factory.IConstantFactory;
import com.wan.dataM.admin.common.exception.BizExceptionEnum;
import com.wan.dataM.admin.common.exception.BussinessException;

import java.lang.reflect.Method;


public class DictFieldWarpperFactory {

    public static Object createFieldWarpper(Object field, String methodName) {
        IConstantFactory me = ConstantFactory.me();
        try {
            Method method = IConstantFactory.class.getMethod(methodName, field.getClass());
            Object result = method.invoke(me, field);
            return result;
        } catch (Exception e) {
            try {
                Method method = IConstantFactory.class.getMethod(methodName, Integer.class);
                Object result = method.invoke(me, Integer.parseInt(field.toString()));
                return result;
            } catch (Exception e1) {
                throw new BussinessException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
            }
        }
    }

}
