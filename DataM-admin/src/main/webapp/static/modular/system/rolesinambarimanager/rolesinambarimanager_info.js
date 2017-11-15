/**
 * 初始化进入ambari webui权限管理详情对话框
 */
var RolesinambarimanagerInfoDlg = {
    rolesinambarimanagerInfoData : {},
    validateFields: {
        dataM_account_id: {
            validators: {
                notEmpty: {
                    message: 'dataM账号id不能为空'
                }
            }
        },
        dataM_account: {
            validators: {
                notEmpty: {
                    message: 'dataM账号不能为空'
                }
            }
        },
        ambari_user_id: {
            validators: {
                notEmpty: {
                    message: 'ambari账号id不能为空'
                }
            }
        },
        ambari_user_name: {
            validators: {
                notEmpty: {
                    message: 'ambari账号不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
RolesinambarimanagerInfoDlg.clearData = function() {
    this.rolesinambarimanagerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RolesinambarimanagerInfoDlg.set = function(key, val) {
    this.rolesinambarimanagerInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RolesinambarimanagerInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RolesinambarimanagerInfoDlg.close = function() {
    parent.layer.close(window.parent.Rolesinambarimanager.layerIndex);
}

/**
 * 收集数据
 */
RolesinambarimanagerInfoDlg.collectData = function() {
    this.set('dataM_account_id').set('dataM_account').set('ambari_user_id').set('ambari_user_name');
}

/**
 * 验证数据是否为空
 */
RolesinambarimanagerInfoDlg.validate = function () {
    $('#rolesinambarimanagerInfoForm').data("bootstrapValidator").resetForm();
    $('#rolesinambarimanagerInfoForm').bootstrapValidator('validate');
    return $("#rolesinambarimanagerInfoForm").data('bootstrapValidator').isValid();
}


/**
 * 提交添加
 */
RolesinambarimanagerInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/rolesinambarimanager/add", function(data){
        Feng.success("添加成功!");
        window.parent.Rolesinambarimanager.table.refresh();
        RolesinambarimanagerInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.rolesinambarimanagerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
RolesinambarimanagerInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/rolesinambarimanager/update", function(data){
        Feng.success("修改成功!");
        window.parent.Rolesinambarimanager.table.refresh();
        RolesinambarimanagerInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.rolesinambarimanagerInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("RolesinambarimanagerInfoForm", RolesinambarimanagerInfoDlg.validateFields);
});
