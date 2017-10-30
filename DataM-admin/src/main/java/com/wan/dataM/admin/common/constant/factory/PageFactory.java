package com.wan.dataM.admin.common.constant.factory;

import com.baomidou.mybatisplus.plugins.Page;
import com.wan.dataM.admin.common.constant.state.Order;
import com.wan.dataM.core.support.HttpKit;
import com.wan.dataM.core.util.ToolUtil;

import javax.servlet.http.HttpServletRequest;

public class PageFactory<T> {

    public Page<T> defaultPage() {
        HttpServletRequest request = HttpKit.getRequest();
        int limit = Integer.valueOf(request.getParameter("limit"));
        int offset = Integer.valueOf(request.getParameter("offset"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        if(ToolUtil.isEmpty(sort)){
            Page<T> page = new Page<>((offset / limit + 1), limit);
            page.setOpenSort(false);
            return page;
        }else{
            Page<T> page = new Page<>((offset / limit + 1), limit, sort);
            if(Order.ASC.getDes().equals(order)){
                page.setAsc(true);
            }else{
                page.setAsc(false);
            }
            return page;
        }
    }
}
