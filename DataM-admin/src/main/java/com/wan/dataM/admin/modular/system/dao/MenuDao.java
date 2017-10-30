package com.wan.dataM.admin.modular.system.dao;


import com.wan.dataM.core.node.MenuNode;
import com.wan.dataM.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface MenuDao {


    List<Map<String, Object>> selectMenus(@Param("condition") String condition, @Param("level") String level);


    List<Integer> getMenuIdsByRoleId(@Param("roleId") Integer roleId);


    List<ZTreeNode> menuTreeList();


    List<ZTreeNode> menuTreeListByMenuIds(List<Integer> menuIds);


    int deleteRelationByMenu(Integer menuId);


    List<String> getResUrlsByRoleId(Integer roleId);


    List<MenuNode> getMenusByRoleIds(List<Integer> roleIds);


}
