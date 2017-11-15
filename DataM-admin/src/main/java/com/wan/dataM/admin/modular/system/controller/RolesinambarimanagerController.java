package com.wan.dataM.admin.modular.system.controller;

import com.wan.dataM.admin.common.constant.factory.ConstantFactory;
import com.wan.dataM.admin.common.exception.BizExceptionEnum;
import com.wan.dataM.admin.common.exception.BussinessException;
import com.wan.dataM.admin.common.persistence.dao.RolesinambarimanagerMapper;
import com.wan.dataM.admin.common.persistence.model.Rolesinambarimanager;
import com.wan.dataM.admin.modular.system.dao.RolesinambarimanagerDao;
import com.wan.dataM.admin.modular.system.service.IRolesinambarimanagerService;
import com.wan.dataM.core.base.controller.BaseController;
import com.wan.dataM.core.base.tips.Tip;
import com.wan.dataM.core.util.ToolUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 进入ambari webui权限管理控制器
 *
 * @Date 2017-11-14 11:47:31
 */
@Controller
@RequestMapping("/rolesinambarimanager")
public class RolesinambarimanagerController extends BaseController {

    private String PREFIX = "/system/rolesinambarimanager/";

    @Resource
    RolesinambarimanagerDao rolesinambarimanagerDao;

    @Resource
    RolesinambarimanagerMapper rolesinambarimanagerMapper;

    @Resource
    IRolesinambarimanagerService rolesinambarimanagerService;

    /**
     * 跳转到进入ambari webui权限管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "rolesinambarimanager.html";
    }

    /**
     * 跳转到添加进入ambari webui权限管理
     */
    @RequestMapping("/rolesinambarimanager_add")
    public String rolesinambarimanagerAdd() {
        return PREFIX + "rolesinambarimanager_add.html";
    }

    /**
     * 跳转到修改进入ambari webui权限管理
     */
    @RequestMapping("/rolesinambarimanager_update/{rolesinambarimanagerId}")
    public String rolesinambarimanagerUpdate(@PathVariable Integer rolesinambarimanagerId, Model model) {
        return PREFIX + "rolesinambarimanager_edit.html";
    }

    /**
     * 获取进入ambari webui权限管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        List<Map<String, Object>> list = this.rolesinambarimanagerDao.list(condition);
        return list;
    }

    /**
     * 新增进入ambari webui权限管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Tip add(@Valid Rolesinambarimanager rolesinambarimanager, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        //判断是否存在该编号
        String existedRolesinambarimanagerDataM_account = ConstantFactory.me().getRolesinambarimanagerDataM_accountByDataM_account_id(rolesinambarimanager.getDataM_account_id());
        if (ToolUtil.isNotEmpty(existedRolesinambarimanagerDataM_account)) {
            throw new BussinessException(BizExceptionEnum.EXISTED_THE_ROLESINAMBARIMANAGER);
        }

        this.rolesinambarimanagerMapper.insert(rolesinambarimanager);
        return SUCCESS_TIP;
    }

    /**
     * 删除进入ambari webui权限管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改进入ambari webui权限管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 进入ambari webui权限管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
