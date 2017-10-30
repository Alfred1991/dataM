package com.wan.dataM.admin.modular.system.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.wan.dataM.admin.common.constant.factory.PageFactory;
import com.wan.dataM.admin.common.persistence.model.OperationLog;
import com.wan.dataM.admin.modular.system.dao.AmbariDao;
import com.wan.dataM.admin.modular.system.warpper.LogWarpper;
import com.wan.dataM.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 测试控制器
 *
 * @Author chenran
 * @Date 2017-10-30 17:00:10
 */
@Controller
@RequestMapping("/ambari")
public class AmbariController extends BaseController {

    private String PREFIX = "/system/ambari/";

    @Resource
    private AmbariDao ambariDao;


    /**
     * 跳转到测试首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "ambari.html";
    }

    /**
     * 跳转到添加测试
     */
    @RequestMapping("/ambari_add")
    public String ambariAdd() {
        return PREFIX + "ambari_add.html";
    }

    /**
     * 跳转到修改测试
     */
    @RequestMapping("/ambari_update/{ambariId}")
    public String ambariUpdate(@PathVariable Integer ambariId, Model model) {
        return PREFIX + "ambari_edit.html";
    }

    /**
     * 获取测试列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<OperationLog> page = new PageFactory<OperationLog>().defaultPage();
        List<Map<String, Object>> result = ambariDao.getAmbariAlertDefinitions(page,page.getOrderByField(), page.isAsc());
        page.setRecords((List<OperationLog>) new LogWarpper(result).warp());
        return super.packForBT(page);
    }

    /**
     * 新增测试
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除测试
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改测试
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 测试详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
