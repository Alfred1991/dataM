package com.wan.dataM.admin.modular.system.warpper;


import com.wan.dataM.admin.common.constant.factory.ConstantFactory;
import com.wan.dataM.core.base.warpper.BaseControllerWarpper;

import java.util.List;
import java.util.Map;

public class RoleWarpper extends BaseControllerWarpper {

    public RoleWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("pName", ConstantFactory.me().getSingleRoleName((Integer) map.get("pid")));
        map.put("deptName", ConstantFactory.me().getDeptName((Integer) map.get("deptid")));
    }

}
