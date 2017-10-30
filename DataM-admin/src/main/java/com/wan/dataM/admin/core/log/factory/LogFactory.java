package com.wan.dataM.admin.core.log.factory;


import com.wan.dataM.admin.common.constant.state.LogSucceed;
import com.wan.dataM.admin.common.constant.state.LogType;
import com.wan.dataM.admin.common.persistence.model.LoginLog;
import com.wan.dataM.admin.common.persistence.model.OperationLog;

import java.util.Date;


public class LogFactory {


    public static OperationLog createOperationLog(LogType logType, Integer userId, String bussinessName, String clazzName, String methodName, String msg, LogSucceed succeed) {
        OperationLog operationLog = new OperationLog();
        operationLog.setLogtype(logType.getMessage());
        operationLog.setLogname(bussinessName);
        operationLog.setUserid(userId);
        operationLog.setClassname(clazzName);
        operationLog.setMethod(methodName);
        operationLog.setCreatetime(new Date());
        operationLog.setSucceed(succeed.getMessage());
        operationLog.setMessage(msg);
        return operationLog;
    }


    public static LoginLog createLoginLog(LogType logType, Integer userId, String msg,String ip) {
        LoginLog loginLog = new LoginLog();
        loginLog.setLogname(logType.getMessage());
        loginLog.setUserid(userId);
        loginLog.setCreatetime(new Date());
        loginLog.setSucceed(LogSucceed.SUCCESS.getMessage());
        loginLog.setIp(ip);
        loginLog.setMessage(msg);
        return loginLog;
    }
}
