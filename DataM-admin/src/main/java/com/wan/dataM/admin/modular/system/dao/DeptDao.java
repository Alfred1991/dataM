package com.wan.dataM.admin.modular.system.dao;


import com.wan.dataM.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface DeptDao {


    List<ZTreeNode> tree();

    List<Map<String, Object>> list(@Param("condition") String condition);
}
