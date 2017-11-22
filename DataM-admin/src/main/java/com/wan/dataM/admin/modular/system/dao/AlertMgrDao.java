package com.wan.dataM.admin.modular.system.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/20.
 */
public interface AlertMgrDao {

    /**
     * 获取dm_monitor_info表中各报警信息现在的状态
     */

    Map<String, Object> selectDM_alert_info(@Param("id") Integer id);

    boolean updateDM_alert_info(@Param("id") Integer id);


    int getStatus();
}
