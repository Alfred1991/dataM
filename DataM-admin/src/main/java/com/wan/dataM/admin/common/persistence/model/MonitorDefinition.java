package com.wan.dataM.admin.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by chenran on 2017/11/15 0015.
 */
public class MonitorDefinition extends Model<MonitorDefinition>{

    /**
     * 主键id
     */
    @TableId(value="monitor_id", type= IdType.AUTO)
    private Integer monitor_id;
    private Integer definition_id;
    private String definition_name;
    private String service_name;
    private String component_name;
    private Integer schedule_interval;
    private String alert_label;
    private Integer alert_type;
    private String alert_content;
    private Integer can_auto_recover;
    private String auto_recover_api;
    private Timestamp create_time;
    private Timestamp modify_time;
    private String desc;

    public Integer getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(Integer monitor_id) {
        this.monitor_id = monitor_id;
    }

    public Integer getDefinition_id() {
        return definition_id;
    }

    public void setDefinition_id(Integer definition_id) {
        this.definition_id = definition_id;
    }

    public String getDefinition_name() {
        return definition_name;
    }

    public void setDefinition_name(String definition_name) {
        this.definition_name = definition_name;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getComponent_name() {
        return component_name;
    }

    public void setComponent_name(String component_name) {
        this.component_name = component_name;
    }

    public Integer getSchedule_interval() {
        return schedule_interval;
    }

    public void setSchedule_interval(Integer schedule_interval) {
        this.schedule_interval = schedule_interval;
    }

    public String getAlert_label() {
        return alert_label;
    }

    public void setAlert_label(String alert_label) {
        this.alert_label = alert_label;
    }

    public Integer getAlert_type() {
        return alert_type;
    }

    public void setAlert_type(Integer alert_type) {
        this.alert_type = alert_type;
    }

    public String getAlert_content() {
        return alert_content;
    }

    public void setAlert_content(String alert_content) {
        this.alert_content = alert_content;
    }

    public Integer getCan_auto_recover() {
        return can_auto_recover;
    }

    public void setCan_auto_recover(Integer can_auto_recover) {
        this.can_auto_recover = can_auto_recover;
    }

    public String getAuto_recover_api() {
        return auto_recover_api;
    }

    public void setAuto_recover_api(String auto_recover_api) {
        this.auto_recover_api = auto_recover_api;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getModify_time() {
        return modify_time;
    }

    public void setModify_time(Timestamp modify_time) {
        this.modify_time = modify_time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
