package com.wan.dataM.admin.modular.system.warpper;


import com.wan.dataM.admin.common.constant.factory.ConstantFactory;
import com.wan.dataM.core.base.warpper.BaseControllerWarpper;
import com.wan.dataM.core.constant.IsMenu;

import java.util.List;
import java.util.Map;


public class MenuWarpper extends BaseControllerWarpper {

    public MenuWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("statusName", ConstantFactory.me().getMenuStatusName((Integer) map.get("status")));
        map.put("isMenuName", IsMenu.valueOf((Integer) map.get("ismenu")));
    }

}
