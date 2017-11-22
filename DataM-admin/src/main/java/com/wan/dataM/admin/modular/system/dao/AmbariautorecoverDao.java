package com.wan.dataM.admin.modular.system.dao;

import com.wan.dataM.admin.common.persistence.model.DmAlertInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ambari自动恢复Dao
 *
 */
public interface AmbariautorecoverDao {

    List<Map<String,Object>> selectCriticals();

    List<Map<String,Object>> selectOks();

    List<Map<String,Object>> selectAutoRecovers();

    List<Map<String,Object>> list(@Param("definition_id")String definition_id,@Param("service_name") String service_name,@Param("component_name") String component_name
            ,@Param("host_name") String host_name,@Param("alert_id") String alert_id,@Param("alert_time_begin") String alert_time_begin,@Param("alert_time_end") String alert_time_end);

    DmAlertInfo selectLastAlert(@Param("monitor_id")String monitor_id, @Param("definition_id")String definition_id, @Param("service_name")String service_name
    , @Param("component_name")String component_name, @Param("host_name")String host_name);

}
