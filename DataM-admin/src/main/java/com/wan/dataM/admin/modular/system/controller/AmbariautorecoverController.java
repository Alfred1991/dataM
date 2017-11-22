package com.wan.dataM.admin.modular.system.controller;

import com.wan.dataM.admin.modular.system.dao.AmbariautorecoverDao;
import com.wan.dataM.admin.modular.system.service.IAmbariautorecoverService;
import com.wan.dataM.core.base.controller.BaseController;
import com.wan.dataM.core.base.tips.Tip;
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
 * ambari自动恢复控制器
 *
 * @Date 2017-11-20 15:40:56
 */
@Controller
@RequestMapping("/ambariautorecover")
public class AmbariautorecoverController extends BaseController {

    @Resource
    IAmbariautorecoverService ambariautorecoverService;

    @Resource
    AmbariautorecoverDao ambariautorecoverDao;

    private static boolean isstarted = false;

    private static Object lock = new Object();

    private String PREFIX = "/system/ambariautorecover/";

    /**
     * 跳转到ambari自动恢复首页
     */
    @RequestMapping("")
    public String index(Model model) {
        String message = "启动自动恢复";
        synchronized (lock) {
            if(isstarted){
                message="停止自动恢复";
            }
        }
        model.addAttribute("isstarted", message);

        return PREFIX + "ambariautorecover.html";
    }

    /**
     * 操作自动恢复状态
     */
    @RequestMapping("/operation")
    @ResponseBody
    public Tip operation(@RequestParam String operation) {

        boolean opera = operation.equals("start")?true:false;

        synchronized (lock) {
            if(opera!=isstarted){
                isstarted=opera;
                if(opera){
                    //启动
                    ambariautorecoverService.startAutoRecover();
                }else{
                    //停止
                    ambariautorecoverService.stopAutoRecover();
                }
            }
        }
        return super.SUCCESS_TIP;
    }

    /**
     * 跳转到添加ambari自动恢复
     */
    @RequestMapping("/ambariautorecover_add")
    public String ambariautorecoverAdd() {
        return PREFIX + "ambariautorecover_add.html";
    }

    /**
     * 跳转到修改ambari自动恢复
     */
    @RequestMapping("/ambariautorecover_update/{ambariautorecoverId}")
    public String ambariautorecoverUpdate(@PathVariable Integer ambariautorecoverId, Model model) {
        return PREFIX + "ambariautorecover_edit.html";
    }

    /**
     * 获取ambari自动恢复列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String definition_id,String service_name,String component_name
            ,String host_name,String alert_id,String alert_time_begin,String alert_time_end) {

        if(alert_time_begin==null||alert_time_begin.equals("")){
            alert_time_begin="0000-00-00 00:00:00";
        }

        if(alert_time_end==null||alert_time_end.equals("")){
            alert_time_end="9999-12-31 23:59:59";
        }

        List<Map<String, Object>> list = this.ambariautorecoverDao.list(definition_id,service_name,component_name,host_name,alert_id,alert_time_begin,alert_time_end);

        return list;
    }

    /**
     * 新增ambari自动恢复
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除ambari自动恢复
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改ambari自动恢复
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * ambari自动恢复详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
