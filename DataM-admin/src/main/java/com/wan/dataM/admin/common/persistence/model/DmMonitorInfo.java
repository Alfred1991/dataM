package com.wan.dataM.admin.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lh on 2017/11/21.
 */

@TableName("dm_monitor_info")
public class DmMonitorInfo extends Model<DmMonitorInfo>{
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value="monitor_id", type= IdType.AUTO)
    private Integer monitorId;
    /**
     * 菜单编号
     */
    private Integer definitionId;
    /**
     * 菜单编号
     */
    private String definitionName;
    /**
     * 菜单编号
     */
    private String serviceName;
    /**
     * 菜单编号
     */
    private String componentName;
    /**
     * 菜单编号
     */
    private Integer scheduleInterval;
    /**
     * 菜单编号
     */
    private String alertLabel;
    /**
     * 菜单编号
     */
    private Integer alertType;
    /**
     * 菜单编号
     */
    private String alertContent;
    /**
     * 菜单编号
     */
    private Integer canAutoRecover;
    /**
     * 菜单编号
     */
    private String autoRecoverApi;
    /**
     * 菜单编号
     */
    private Date createTime;
    /**
     * 菜单编号
     */
    private Date modifyTime;

    /**
     * 菜单编号
     */
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
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
        return this.monitorId;
    }

    @Override
    public String toString() {
        return "DmMonitorInfo{" +
                "monitorId=" + monitorId +
                ", definitionId=" + definitionId +
                ", definitionName='" + definitionName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", componentName='" + componentName + '\'' +
                ", scheduleInterval=" + scheduleInterval +
                ", alertLabel='" + alertLabel + '\'' +
                ", alertType=" + alertType +
                ", alertContent='" + alertContent + '\'' +
                ", canAutoRecover=" + canAutoRecover +
                ", autoRecoverApi='" + autoRecoverApi + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", varchar='" + desc + '\'' +
                '}';
    }
}
