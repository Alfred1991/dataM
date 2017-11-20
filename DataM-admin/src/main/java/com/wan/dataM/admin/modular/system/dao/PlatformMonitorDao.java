package com.wan.dataM.admin.modular.system.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.wan.dataM.admin.common.persistence.model.OperationLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 平台监控管理Dao
 *
 */
public interface PlatformMonitorDao {

    List<Map<String, Object>> getPlatformMonitorDefinitions(@Param("page") Page<OperationLog> page,  @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

    Map<String,Object> getPlatformMonitorDefinitionById(Integer ambariId);

    Map<String,Object> getPlatformMonitorDefinitionByDefinitionId(@Param("definitionId") Integer definitionId);

    boolean insertPlatformMonitorDefinition(@Param("definitionId") Integer definitionId,@Param("definitionName") String definitionName,
                                            @Param("serviceName") String serviceName,@Param("componentName") String componentName,
                                            @Param("scheduleInterval") Integer scheduleInterval,@Param("alertLabel") String alertLabel);


}
