package com.wan.dataM.admin.modular.system.warpper;


import com.wan.dataM.admin.common.constant.factory.ConstantFactory;
import com.wan.dataM.core.base.warpper.BaseControllerWarpper;

import java.util.Map;


public class NoticeWrapper extends BaseControllerWarpper {

    public NoticeWrapper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Integer creater = (Integer) map.get("creater");
        map.put("createrName", ConstantFactory.me().getUserNameById(creater));
    }

}
