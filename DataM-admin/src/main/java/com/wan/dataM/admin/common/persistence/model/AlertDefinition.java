package com.wan.dataM.admin.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * Created by chenran on 2017/11/15 0015.
 */
public class AlertDefinition  extends Model<AlertDefinition> {


    /**
     * 主键id
     */
    @TableId(value="definition_id")
    private Long definition_id;

    private Long cluster_id;

    private String definition_name;

    private String service_name;

    private String component_name;

    private String scope;

    private String label;

    private String help_url;

    private String description;

    private Integer enabled;

    private Integer schedule_interval;

    private String source_type;

    private String alert_source;

    private String hash;

    private Integer ignore_host;

    private Integer repeat_tolerance;

    private Integer repeat_tolerance_enabled;

    public Long getDefinition_id() {
        return definition_id;
    }

    public void setDefinition_id(Long definition_id) {
        this.definition_id = definition_id;
    }

    public Long getCluster_id() {
        return cluster_id;
    }

    public void setCluster_id(Long cluster_id) {
        this.cluster_id = cluster_id;
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHelp_url() {
        return help_url;
    }

    public void setHelp_url(String help_url) {
        this.help_url = help_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getSchedule_interval() {
        return schedule_interval;
    }

    public void setSchedule_interval(Integer schedule_interval) {
        this.schedule_interval = schedule_interval;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public String getAlert_source() {
        return alert_source;
    }

    public void setAlert_source(String alert_source) {
        this.alert_source = alert_source;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getIgnore_host() {
        return ignore_host;
    }

    public void setIgnore_host(Integer ignore_host) {
        this.ignore_host = ignore_host;
    }

    public Integer getRepeat_tolerance() {
        return repeat_tolerance;
    }

    public void setRepeat_tolerance(Integer repeat_tolerance) {
        this.repeat_tolerance = repeat_tolerance;
    }

    public Integer getRepeat_tolerance_enabled() {
        return repeat_tolerance_enabled;
    }

    public void setRepeat_tolerance_enabled(Integer repeat_tolerance_enabled) {
        this.repeat_tolerance_enabled = repeat_tolerance_enabled;
    }

    @Override
    public String toString() {
        return "AlertDefinition{" +
                "definition_id=" + definition_id +
                ", cluster_id=" + cluster_id +
                ", definition_name='" + definition_name + '\'' +
                ", service_name='" + service_name + '\'' +
                ", component_name='" + component_name + '\'' +
                ", scope='" + scope + '\'' +
                ", label='" + label + '\'' +
                ", help_url='" + help_url + '\'' +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", schedule_interval=" + schedule_interval +
                ", source_type='" + source_type + '\'' +
                ", alert_source='" + alert_source + '\'' +
                ", hash='" + hash + '\'' +
                ", ignore_host=" + ignore_host +
                ", repeat_tolerance=" + repeat_tolerance +
                ", repeat_tolerance_enabled=" + repeat_tolerance_enabled +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
