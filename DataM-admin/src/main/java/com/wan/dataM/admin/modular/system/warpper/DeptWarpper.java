package com.wan.dataM.admin.modular.system.warpper;


import com.wan.dataM.admin.common.constant.factory.ConstantFactory;
import com.wan.dataM.core.base.warpper.BaseControllerWarpper;
import com.wan.dataM.core.util.ToolUtil;

import java.util.Map;


public class DeptWarpper extends BaseControllerWarpper {

    public DeptWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {

        Integer pid = (Integer) map.get("pid");

        if (ToolUtil.isEmpty(pid) || pid.equals(0)) {
            map.put("pName", "--");
        } else {
            map.put("pName", ConstantFactory.me().getDeptName(pid));
        }
    }

}
