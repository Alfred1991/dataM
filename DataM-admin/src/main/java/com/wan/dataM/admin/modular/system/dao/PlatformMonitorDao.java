package com.wan.dataM.admin.modular.system.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.wan.dataM.admin.common.persistence.model.MonitorDefinition;
import com.wan.dataM.admin.common.persistence.model.OperationLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 平台监控管理Dao
 *
 */
public interface PlatformMonitorDao {
    //点击平台监控管理模块后，显示的数据
    List<Map<String, Object>> getPlatformMonitorDefinitions(@Param("page") Page<OperationLog> page,  @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

    Map<String,Object> getPlatformMonitorDefinitionById(Integer ambariId);

    //判断该definitionID是否已存在
    Map<String,Object> getPlatformMonitorDefinitionByDefinitionId(@Param("definitionId") Integer definitionId);

    //添加监控信息（点击添加按钮并点击提交后）
    boolean insertPlatformMonitorDefinition(@Param("definitionId") Integer definitionId,@Param("definitionName") String definitionName,
                                            @Param("serviceName") String serviceName,@Param("componentName") String componentName,
                                            @Param("scheduleInterval") Integer scheduleInterval,@Param("alertLabel") String alertLabel,
                                            @Param("alertType") Integer alertType,@Param("alertContent") String alertContent,
                                            @Param("canAutoRecover") Integer canAutoRecover,@Param("autoRecoverAPI") String autoRecoverAPI);

    //删除监控信息（点击删除按钮）
    boolean delPlatformMonitorById(@Param("MonitorId") Integer platformMonitorId);
    //修改监控信息（点击修改按钮并且点了提交按钮后）
    boolean updatePlatformMonitorDefinition(@Param("monitorId") Integer monitorId,
                                            @Param("definitionId") Integer definitionId,@Param("definitionName") String definitionName,
                                            @Param("serviceName") String serviceName,@Param("componentName") String componentName,
                                            @Param("scheduleInterval") Integer scheduleInterval,@Param("alertLabel") String alertLabel,
                                            @Param("alertType") Integer alertType,@Param("alertContent") String alertContent,
                                            @Param("canAutoRecover") Integer canAutoRecover,@Param("autoRecoverAPI") String autoRecoverAPI);


    //查询监控信息（点击修改按钮）
    Map<String,Object> selPlatformMonitorBymonitorId(@Param("MonitorId") Integer MonitorId);

    //点击搜索按钮后
    List<Map<String, Object>> selectPlatformMonitor(@Param("condition") String condition);
}
