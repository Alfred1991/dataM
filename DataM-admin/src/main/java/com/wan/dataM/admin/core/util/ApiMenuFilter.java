package com.wan.dataM.admin.core.util;


import com.wan.dataM.admin.common.constant.Const;
import com.wan.dataM.admin.config.properties.DataMProperties;
import com.wan.dataM.core.node.MenuNode;
import com.wan.dataM.core.util.SpringContextHolder;

import java.util.ArrayList;
import java.util.List;


public class ApiMenuFilter extends MenuNode {


    public static List<MenuNode> build(List<MenuNode> nodes) {

        //如果关闭了接口文档,则不显示接口文档菜单
        DataMProperties dataMProperties = SpringContextHolder.getBean(DataMProperties.class);
        if (!dataMProperties.getSwaggerOpen()) {
            List<MenuNode> menuNodesCopy = new ArrayList<>();
            for (MenuNode menuNode : nodes) {
                if (Const.API_MENU_NAME.equals(menuNode.getName())) {
                    continue;
                } else {
                    menuNodesCopy.add(menuNode);
                }
            }
            nodes = menuNodesCopy;
        }

        return nodes;
    }
}
