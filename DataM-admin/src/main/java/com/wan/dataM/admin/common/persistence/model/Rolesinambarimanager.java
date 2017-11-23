package com.wan.dataM.admin.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * Created by lh on 2017/11/14.
 */
public class Rolesinambarimanager extends Model<Rolesinambarimanager> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * dataM账号id
     */
    private Integer datamaccountid;
    /**
     * dataM账号
     */
    private String datamaccount;
    /**
     * ambari账号id
     */
    private Integer ambariuserid;
    /**
     * ambari账号
     */
    private String ambariusername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatamaccount() {
        return datamaccount;
    }

    public void setDatamaccount(String datamaccount) {
        this.datamaccount = datamaccount;
    }

    public String getAmbariusername() {
        return ambariusername;
    }

    public void setAmbariusername(String ambariusername) {
        this.ambariusername = ambariusername;
    }

    public Integer getDatamaccountid() {
        return datamaccountid;
    }

    public void setDatamaccountid(Integer datamaccountid) {
        this.datamaccountid = datamaccountid;
    }

    public Integer getAmbariuserid() {
        return ambariuserid;
    }

    public void setAmbariuserid(Integer ambariuserid) {
        this.ambariuserid = ambariuserid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "id=" + id +
                ", datamaccountid=" + datamaccountid +
                ", datamaccount=" + datamaccount +
                ", ambariusername=" + ambariusername +
                "}";
    }
}
