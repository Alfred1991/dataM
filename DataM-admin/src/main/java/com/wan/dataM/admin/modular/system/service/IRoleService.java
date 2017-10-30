package com.wan.dataM.admin.modular.system.service;


public interface IRoleService {


    void setAuthority(Integer roleId, String ids);

    void delRoleById(Integer roleId);
}
