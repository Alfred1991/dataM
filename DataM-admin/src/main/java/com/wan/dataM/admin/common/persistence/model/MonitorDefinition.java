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
    @TableId(value="monitorId", type= IdType.AUTO)
    private Integer monitorId;
    private Integer definitionId;
    private String definitionName;
    private String serviceName;
    private String componentName;
    private Integer scheduleInterval;
    private String alertLabel;
    private Integer alertType;
    private String alertContent;
    private Integer canAutoRecover;
    private String autoRecoverApi;
    private Timestamp createTime;
    private Timestamp modifyTime;
    private String desc;

    public Integer getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

    public Integer getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(Integer definitionId) {
        this.definitionId = definitionId;
    }

    public String getDefinitionName() {
        return definitionName;
    }

    public void setDefinitionName(String definitionName) {
        this.definitionName = definitionName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public Integer getScheduleInterval() {
        return scheduleInterval;
    }

    public void setScheduleInterval(Integer scheduleInterval) {
        this.scheduleInterval = scheduleInterval;
    }

    public String getAlertLabel() {
        return alertLabel;
    }

    public void setAlertLabel(String alertLabel) {
        this.alertLabel = alertLabel;
    }

    public Integer getAlertType() {
        return alertType;
    }

    public void setAlertType(Integer alertType) {
        this.alertType = alertType;
    }

    public String getAlertContent() {
        return alertContent;
    }

    public void setAlertContent(String alertContent) {
        this.alertContent = alertContent;
    }

    public Integer getCanAutoRecover() {
        return canAutoRecover;
    }

    public void setCanAutoRecover(Integer canAutoRecover) {
        this.canAutoRecover = canAutoRecover;
    }

    public String getAutoRecoverApi() {
        return autoRecoverApi;
    }

    public void setAutoRecoverApi(String autoRecoverApi) {
        this.autoRecoverApi = autoRecoverApi;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
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
