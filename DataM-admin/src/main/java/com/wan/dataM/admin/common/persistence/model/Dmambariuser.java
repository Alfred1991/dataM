package com.wan.dataM.admin.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lh on 2017/11/17.
 */
public class Dmambariuser extends Model<Relation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 菜单编号
     */
    private String username;
    /**
     * 菜单父编号
     */
    private String userpassword;
    /**
     * 当前菜单的所有父菜单编号
     */
    private Integer usertype;
    /**
     * 菜单名称
     */
    private String userdesc;
    /**
     * 菜单图标
     */
    private Date createtime;
    /**
     * url地址
     */
    private Integer deletestatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Dmambariuser{" +
                "id=" + id +
                ", username=" + username +
                ", userpassword=" + userpassword +
                ", usertype=" + usertype +
                ", userdesc=" + userdesc +
                ", createtime=" + createtime +
                ", deletestatus=" + deletestatus +
                "}";
    }

}
