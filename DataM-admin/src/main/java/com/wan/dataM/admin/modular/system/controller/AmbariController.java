package com.wan.dataM.admin.modular.system.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.wan.dataM.admin.common.constant.factory.PageFactory;
import com.wan.dataM.admin.common.exception.BizExceptionEnum;
import com.wan.dataM.admin.common.exception.BussinessException;
import com.wan.dataM.admin.common.persistence.dao.AlertDefinitionMapper;
import com.wan.dataM.admin.common.persistence.model.AlertDefinition;
import com.wan.dataM.admin.common.persistence.model.OperationLog;
import com.wan.dataM.admin.core.util.MapperConvertor;
import com.wan.dataM.admin.modular.system.dao.AmbariDao;
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

    @Resource
    private AlertDefinitionMapper alertDefinitionMapper;


    /**
     * 跳转到测试首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "ambari.html";
    }

    /**
     * 将ambari的告警定义直接添加为平台监控管理项
     */
    @RequestMapping("/add")
    public Object ambariAdd() {




        return super.SUCCESS_TIP;
    }

    /**
     * 跳转到展示ambari具体监控项
     */
    @RequestMapping("/ambari_update/{ambariId}")
    public String ambariUpdate(@PathVariable Integer ambariId, Model model) {
        if (ToolUtil.isEmpty(ambariId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        Map<String,Object> alertDefinition = this.ambariDao.getAmbariAlertDefinitionById(ambariId);

        AlertDefinition alertDefinitionModel = new AlertDefinition();
        MapperConvertor.convertAlertDefinitionMapper(alertDefinition, alertDefinitionModel);
        model.addAttribute(alertDefinitionModel);
        return PREFIX + "ambari_edit.html";
    }

    /**
     * 获取测试列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String definitionName) {
        Page<OperationLog> page = new PageFactory<OperationLog>().defaultPage();
        List<Map<String, Object>> result = ambariDao.getAmbariAlertDefinitions(page,page.getOrderByField(), page.isAsc(), definitionName);
        page.setRecords((List<OperationLog>) new LogWarpper(result).warp());
        return super.packForBT(page);
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
