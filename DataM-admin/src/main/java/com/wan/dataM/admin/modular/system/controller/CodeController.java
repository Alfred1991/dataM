package com.wan.dataM.admin.modular.system.controller;


import com.wan.dataM.admin.common.annotion.Permission;
import com.wan.dataM.admin.common.constant.Const;
import com.wan.dataM.admin.common.exception.BizExceptionEnum;
import com.wan.dataM.admin.common.exception.BussinessException;
import com.wan.dataM.admin.core.template.config.ContextConfig;
import com.wan.dataM.admin.core.template.engine.SimpleTemplateEngine;
import com.wan.dataM.admin.core.template.engine.base.BaseTemplateEngine;
import com.wan.dataM.core.base.controller.BaseController;
import com.wan.dataM.core.util.ToolUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/code")
public class CodeController extends BaseController {

    private String PREFIX = "/system/code/";

    /**
     * 跳转到代码生成首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "code.html";
    }

    /**
     * 代码生成
     */
    @ApiOperation("生成代码")
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ResponseBody
    @Permission(Const.ADMIN_NAME)
    public Object add(@ApiParam(value = "模块名称",required = true) @RequestParam  String moduleName,
                      @RequestParam String bizChName,
                      @RequestParam String bizEnName,
                      @RequestParam String path) {
        if (ToolUtil.isOneEmpty(bizChName, bizEnName)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        ContextConfig contextConfig = new ContextConfig();
        contextConfig.setBizChName(bizChName);
        contextConfig.setBizEnName(bizEnName);
        contextConfig.setModuleName(moduleName);
        if (ToolUtil.isNotEmpty(path)) {
            contextConfig.setProjectPath(path);
        }

        BaseTemplateEngine dataMTemplateEngine = new SimpleTemplateEngine();
        dataMTemplateEngine.setContextConfig(contextConfig);
        dataMTemplateEngine.start();

        return super.SUCCESS_TIP;
    }
}
