package com.wan.dataM.admin.core.util;

import com.wan.dataM.admin.common.persistence.model.AlertDefinition;

import java.util.Map;

/**
 * Created by chenran on 2017/11/15 0015.
 */
public class MapperConvertor {


    public static boolean convertAlertDefinitionMapper(Map<String,Object> resultMap,AlertDefinition alertDefinition){
        alertDefinition.setDefinition_id((Long)resultMap.get("definition_id"));
        alertDefinition.setCluster_id((Long) resultMap.get("cluster_id"));
        alertDefinition.setDefinition_name((String)resultMap.get("definition_name"));
        alertDefinition.setService_name((String)resultMap.get("service_name"));
        alertDefinition.setComponent_name((String)resultMap.get("component_name"));
        alertDefinition.setScope((String)resultMap.get("scope"));
        alertDefinition.setLabel((String)resultMap.get("label"));
        alertDefinition.setHelp_url((String)resultMap.get("help_url"));
        alertDefinition.setDescription((String)resultMap.get("description"));
        alertDefinition.setEnabled((Integer)resultMap.get("enabled"));
        alertDefinition.setSchedule_interval((Integer)resultMap.get("schedule_interval"));
        alertDefinition.setSource_type((String)resultMap.get("source_type"));
        alertDefinition.setAlert_source((String)resultMap.get("alert_source"));
        alertDefinition.setHash((String)resultMap.get("hash"));
        alertDefinition.setIgnore_host((Integer)resultMap.get("ignore_host"));
        alertDefinition.setRepeat_tolerance((Integer)resultMap.get("repeat_tolerance"));
        alertDefinition.setRepeat_tolerance_enabled((Integer)resultMap.get("repeat_tolerance_enabled"));
        return false;
    }



}
