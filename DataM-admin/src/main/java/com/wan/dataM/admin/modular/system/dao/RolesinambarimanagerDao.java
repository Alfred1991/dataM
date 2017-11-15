package com.wan.dataM.admin.modular.system.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 进入ambari webui权限管理Dao
 *
 */
public interface RolesinambarimanagerDao {

    List<Map<String,Object>> list(@Param("condition") String conditiion);

}
