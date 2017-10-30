package com.wan.dataM.admin.modular.system.dao;


import com.wan.dataM.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleDao {


    List<Map<String, Object>> selectRoles(@Param("condition") String condition);


    int deleteRolesById(@Param("roleId") Integer roleId);


    List<ZTreeNode> roleTreeList();


    List<ZTreeNode> roleTreeListByRoleId(String[] roleId);


}
