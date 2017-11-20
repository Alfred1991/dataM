package com.wan.dataM.admin.modular.system.controller;

import com.wan.dataM.admin.common.persistence.dao.DmambariuserMapper;
import com.wan.dataM.admin.common.persistence.model.Dmambariuser;
import com.wan.dataM.admin.core.shiro.ShiroKit;
import com.wan.dataM.admin.core.shiro.ShiroUser;
import com.wan.dataM.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.URLEncoder;

/**
 * 进入ambari webui控制器
 *
 * @Date 2017-11-13 09:30:05
 */
@Controller
@RequestMapping("/enterambariwebui")
public class EnterambariwebuiController extends BaseController {

    private String PREFIX = "/system/enterambariwebui/";

    @Resource
    DmambariuserMapper dmambariuserMapper;


    /**
     * 跳转到进入ambari webui首页
     */
    @RequestMapping("")
    public String index(Model model) {
        ShiroUser shiroUser = ShiroKit.getUser();
        Integer id = shiroUser.getId();
        Dmambariuser dmambariuser = dmambariuserMapper.selectById(id);
        String token= URLEncoder.encode(dmambariuser.getUserpassword());
        model.addAttribute("token", token);
        return PREFIX + "enterambariwebui.html";
    }

    /**
     * 跳转到添加进入ambari webui
     */
    @RequestMapping("/enterambariwebui_add")
    public String enterambariwebuiAdd() {
        return PREFIX + "enterambariwebui_add.html";
    }

    /**
     * 跳转到修改进入ambari webui
     */
    @RequestMapping("/enterambariwebui_update/{enterambariwebuiId}")
    public String enterambariwebuiUpdate(@PathVariable Integer enterambariwebuiId, Model model) {
        return PREFIX + "enterambariwebui_edit.html";
    }

    /**
     * 获取进入ambari webui列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增进入ambari webui
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除进入ambari webui
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改进入ambari webui
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 进入ambari webui详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
