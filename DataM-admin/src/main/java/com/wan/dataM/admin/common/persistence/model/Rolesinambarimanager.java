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
    private Integer dataM_account_id;
    /**
     * dataM账号
     */
    private String dataM_account;
    /**
     * ambari账号id
     */
    private String ambari_user_id;
    /**
     * ambari账号
     */
    private String ambari_user_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataM_account() {
        return dataM_account;
    }

    public void setDataM_account(String dataM_account) {
        this.dataM_account = dataM_account;
    }

    public String getAmbari_user_name() {
        return ambari_user_name;
    }

    public void setAmbari_user_name(String ambari_user_name) {
        this.ambari_user_name = ambari_user_name;
    }

    public Integer getDataM_account_id() {
        return dataM_account_id;
    }

    public void setDataM_account_id(Integer dataM_account_id) {
        this.dataM_account_id = dataM_account_id;
    }

    public String getAmbari_user_id() {
        return ambari_user_id;
    }

    public void setAmbari_user_id(String ambari_user_id) {
        this.ambari_user_id = ambari_user_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "id=" + id +
                ", dataM_account_id=" + dataM_account_id +
                ", dataM_account=" + dataM_account +
                ", ambari_user_name=" + ambari_user_name +
                "}";
    }
}
