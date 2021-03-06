package com.wan.dataM.admin.modular.system.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.wan.dataM.admin.common.persistence.model.OperationLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 测试Dao
 *
 */
public interface AmbariDao {

    List<Map<String, Object>> getAmbariAlertDefinitions(@Param("page") Page<OperationLog> page,  @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc,@Param("definitionName") String definitionName);

    Map<String,Object> getAmbariAlertDefinitionById(@Param("ambariId") Integer ambariId);

}
