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

@TableName("dm_alert_info")
public class DmAlertInfo extends Model<DmAlertInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 菜单编号
     */
    private Integer monitorId;
    /**
     * 菜单编号
     */
    private Integer definitionId;
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
    private String hostName;
    /**
     * 菜单编号
     */
    private Integer alertId;
    /**
     * 菜单编号
     */
    private Integer alertType;
    /**
     * 菜单编号
     */
    private Date alertTime;
    /**
     * 菜单编号
     */
    private Integer alertSendCount;
    /**
     * 菜单编号
     */
    private Date alertSendLastTime;
    /**
     * 菜单编号
     */
    private Integer alertRecoverId;
    /**
     * 菜单编号
     */
    private Integer autoRecoverRetryCount;
    /**
     * 菜单编号
     */
    private Date autoRecoverLastTime;
    /**
     * 菜单编号
     */
    private Date recoverTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public Integer getAlertType() {
        return alertType;
    }

    public void setAlertType(Integer alertType) {
        this.alertType = alertType;
    }

    public Date getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Date alertTime) {
        this.alertTime = alertTime;
    }

    public Integer getAlertSendCount() {
        return alertSendCount;
    }

    public void setAlertSendCount(Integer alertSendCount) {
        this.alertSendCount = alertSendCount;
    }

    public Date getAlertSendLastTime() {
        return alertSendLastTime;
    }

    public void setAlertSendLastTime(Date alertSendLastTime) {
        this.alertSendLastTime = alertSendLastTime;
    }

    public Integer getAlertRecoverId() {
        return alertRecoverId;
    }

    public void setAlertRecoverId(Integer alertRecoverId) {
        this.alertRecoverId = alertRecoverId;
    }

    public Integer getAutoRecoverRetryCount() {
        return autoRecoverRetryCount;
    }

    public void setAutoRecoverRetryCount(Integer autoRecoverRetryCount) {
        this.autoRecoverRetryCount = autoRecoverRetryCount;
    }

    public Date getAutoRecoverLastTime() {
        return autoRecoverLastTime;
    }

    public void setAutoRecoverLastTime(Date autoRecoverLastTime) {
        this.autoRecoverLastTime = autoRecoverLastTime;
    }

    public Date getRecoverTime() {
        return recoverTime;
    }

    public void setRecoverTime(Date recoverTime) {
        this.recoverTime = recoverTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DmAlertInfo{" +
                "id=" + id +
                ", monitorId=" + monitorId +
                ", definitionId=" + definitionId +
                ", serviceName='" + serviceName + '\'' +
                ", componentName='" + componentName + '\'' +
                ", hostName='" + hostName + '\'' +
                ", alertId=" + alertId +
                ", alertType=" + alertType +
                ", alertTime=" + alertTime +
                ", alertSendCount=" + alertSendCount +
                ", alertSendLastTime=" + alertSendLastTime +
                ", alertRecoverId=" + alertRecoverId +
                ", autoRecoverRetryCount=" + autoRecoverRetryCount +
                ", autoRecoverLastTime=" + autoRecoverLastTime +
                ", recoverTime=" + recoverTime +
                '}';
    }
}
