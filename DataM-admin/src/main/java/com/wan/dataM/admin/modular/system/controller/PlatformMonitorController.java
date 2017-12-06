package com.wan.dataM.admin.modular.system.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.wan.dataM.admin.common.annotion.BussinessLog;
import com.wan.dataM.admin.common.constant.Dict;
import com.wan.dataM.admin.common.constant.factory.PageFactory;
import com.wan.dataM.admin.common.exception.BizExceptionEnum;
import com.wan.dataM.admin.common.exception.BussinessException;
import com.wan.dataM.admin.common.persistence.model.MonitorDefinition;
import com.wan.dataM.admin.common.persistence.model.OperationLog;
import com.wan.dataM.admin.modular.system.dao.PlatformMonitorDao;
import com.wan.dataM.admin.modular.system.warpper.LogWarpper;
import com.wan.dataM.core.base.controller.BaseController;
import com.wan.dataM.core.util.ToolUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    private String PREFIX = "/system/platformMonitor/";

    @Resource
    private PlatformMonitorDao platformMonitorDao;

//    @Resource
//    private MonitorDefinitionMapper monitorDefinitionMapper;
//
//    @Resource
//    IPlatformMonitorService platformMonitorService;


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
        //判断传进来的ID是否为空
        if (ToolUtil.isEmpty(platformMonitorId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        System.out.println("select MonitorId = " + platformMonitorId);
        Map<String,Object> monitorDefinition = this.platformMonitorDao.selPlatformMonitorBymonitorId(platformMonitorId);

//        Map<String, Object> monitorDefinitionMap = BeanKit.beanToMap(monitorDefinition);

        model.addAttribute("monitorDefinition", monitorDefinition);
//        System.out.println("map = " + monitorDefinition.get("definition_id"));
//        LogObjectHolder.me().set(monitorDefinition);



        return PREFIX + "platformMonitor_edit.html";
    }

    /**
     * 获取平台监控管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        Page<OperationLog> page = new PageFactory<OperationLog>().defaultPage();
        List<Map<String, Object>> result = platformMonitorDao.selectPlatformMonitor(condition);
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
        Integer definitionId = monitorDefinition.getDefinitionId();
        System.out.println("definitionId = " + definitionId);

        //判断是否已经存在该编号
        Map<String,Object> result = platformMonitorDao.getPlatformMonitorDefinitionByDefinitionId(definitionId);
        if(null != result && result.size() > 0){
            return super.DUPLICATED;
        }
        monitorDefinition.setAlertType(0);
        monitorDefinition.setCanAutoRecover(0);
        monitorDefinition.setAlertContent("");
        monitorDefinition.setAutoRecoverApi("");
        //添加告警信息到数据库中
        platformMonitorDao.insertPlatformMonitorDefinition(monitorDefinition.getDefinitionId(), monitorDefinition.getDefinitionName(),
                monitorDefinition.getServiceName(), monitorDefinition.getComponentName(),
                monitorDefinition.getScheduleInterval(), monitorDefinition.getAlertLabel(),
                monitorDefinition.getAlertType(),monitorDefinition.getAlertContent(),
                monitorDefinition.getCanAutoRecover(),monitorDefinition.getAutoRecoverApi());

        return super.SUCCESS_TIP;
    }

    /**
     * 删除平台监控管理
     */
    @RequestMapping(value = "/delete")
    @BussinessLog(value = "删除平台监控管理", key = "definitionID", dict = Dict.DeleteDict)
    @ResponseBody
    public Object delete(@RequestParam Integer platformMonitorId) {
        if (ToolUtil.isEmpty(platformMonitorId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        System.out.println("del monitorID = " + platformMonitorId);
        this.platformMonitorDao.delPlatformMonitorById(platformMonitorId);
        return SUCCESS_TIP;
    }


    /**
     * 修改平台监控管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(MonitorDefinition monitorDefinition) {
       Integer definitionId = monitorDefinition.getDefinitionId();
        System.out.println("definitionId = " + definitionId);
        //判断是否已经存在该definition_ID
        Map<String,Object> result = platformMonitorDao.getPlatformMonitorDefinitionByDefinitionId(definitionId);
        if(null != result && result.size() > 0){
            return super.DUPLICATED;
        }
        System.out.println("begin to exe update the getMonitor_id() = " + monitorDefinition.getMonitorId());
        //修改告警信息到数据库中
        boolean flag = platformMonitorDao.updatePlatformMonitorDefinition(monitorDefinition.getMonitorId(),
                monitorDefinition.getDefinitionId(), monitorDefinition.getDefinitionName(),
                monitorDefinition.getServiceName(), monitorDefinition.getComponentName(),
                monitorDefinition.getScheduleInterval(), monitorDefinition.getAlertLabel(),
                monitorDefinition.getAlertType(),monitorDefinition.getAlertContent(),
                monitorDefinition.getCanAutoRecover(),monitorDefinition.getAutoRecoverApi());

        System.out.println("flag = " + flag);
        System.out.println("Success ！ " );
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
