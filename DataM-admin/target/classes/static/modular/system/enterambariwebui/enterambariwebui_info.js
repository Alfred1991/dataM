/**
 * 初始化进入ambari webui详情对话框
 */
var EnterambariwebuiInfoDlg = {
    enterambariwebuiInfoData : {}
};

/**
 * 清除数据
 */
EnterambariwebuiInfoDlg.clearData = function() {
    this.enterambariwebuiInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EnterambariwebuiInfoDlg.set = function(key, val) {
    this.enterambariwebuiInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
EnterambariwebuiInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
EnterambariwebuiInfoDlg.close = function() {
    parent.layer.close(window.parent.Enterambariwebui.layerIndex);
}

/**
 * 收集数据
 */
EnterambariwebuiInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
EnterambariwebuiInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/enterambariwebui/add", function(data){
        Feng.success("添加成功!");
        window.parent.Enterambariwebui.table.refresh();
        EnterambariwebuiInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.enterambariwebuiInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
EnterambariwebuiInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/enterambariwebui/update", function(data){
        Feng.success("修改成功!");
        window.parent.Enterambariwebui.table.refresh();
        EnterambariwebuiInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.enterambariwebuiInfoData);
    ajax.start();
}

$(function() {

});
