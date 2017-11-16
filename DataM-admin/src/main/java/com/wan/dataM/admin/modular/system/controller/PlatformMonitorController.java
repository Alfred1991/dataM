package com.wan.dataM.admin.modular.system.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.wan.dataM.admin.common.annotion.BussinessLog;
import com.wan.dataM.admin.common.constant.Dict;
import com.wan.dataM.admin.common.constant.factory.PageFactory;
import com.wan.dataM.admin.common.persistence.dao.MonitorDefinitionMapper;
import com.wan.dataM.admin.common.persistence.model.MonitorDefinition;
import com.wan.dataM.admin.common.persistence.model.OperationLog;
import com.wan.dataM.admin.modular.system.dao.PlatformMonitorDao;
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
 * 平台监控管理控制器
 *
 * @Date 2017-11-15 15:34:54
 */
@Controller
@RequestMapping("/platformMonitor")
public class PlatformMonitorController extends BaseController {

    private String PREFIX = "/platformMonitor/platformMonitor/";

    @Resource
    private PlatformMonitorDao platformMonitorDao;

    @Resource
    private MonitorDefinitionMapper monitorDefinitionMapper;


    /**
     * 跳转到平台监控管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "platformMonitor.html";
    }

    /**
     * 跳转到添加平台监控管理
     */
    @RequestMapping("/platformMonitor_add")
    public String platformMonitorAdd() {
        return PREFIX + "platformMonitor_add.html";
    }

    /**
     * 跳转到修改平台监控管理
     */
    @RequestMapping("/platformMonitor_update/{platformMonitorId}")
    public String platformMonitorUpdate(@PathVariable Integer platformMonitorId, Model model) {
        return PREFIX + "platformMonitor_edit.html";
    }

    /**
     * 获取平台监控管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        Page<OperationLog> page = new PageFactory<OperationLog>().defaultPage();
        List<Map<String, Object>> result = platformMonitorDao.getPlatformMonitorDefinitions(page,page.getOrderByField(), page.isAsc());
        page.setRecords((List<OperationLog>) new LogWarpper(result).warp());
        return super.packForBT(page);
    }

    /**
     * 新增平台监控管理
     */
    @RequestMapping(value = "/add")
    @BussinessLog(value = "新增通知",key = "title",dict = Dict.MonitorDefinitionMap)
    @ResponseBody
    public Object add(MonitorDefinition monitorDefinition) {
        Integer definitionId = monitorDefinition.getDefinition_id();
        Map<String,Object> result = platformMonitorDao.getPlatformMonitorDefinitionByDefinitionId(definitionId);
        if(null != result && result.size() > 0){
            return super.DUPLICATED;
        }
        monitorDefinitionMapper.insert(monitorDefinition);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除平台监控管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改平台监控管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 平台监控管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
