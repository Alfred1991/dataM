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

    Map<String,Object> getPlatformMonitorDefinitionById(@Param("monitorId") Integer ambariId);

    Map<String,Object> getPlatformMonitorDefinitionByDefinitionId(@Param("monitorId") Integer definitionId);


}
