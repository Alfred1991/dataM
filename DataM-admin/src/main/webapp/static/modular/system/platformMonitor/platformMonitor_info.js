/**
 * 初始化平台监控管理详情对话框
 */
var PlatformMonitorInfoDlg = {
    platformMonitorInfoData : {}
};

/**
 * 清除数据
 */
PlatformMonitorInfoDlg.clearData = function() {
    this.platformMonitorInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PlatformMonitorInfoDlg.set = function(key, val) {
    this.platformMonitorInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PlatformMonitorInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PlatformMonitorInfoDlg.close = function() {
    parent.layer.close(window.parent.PlatformMonitor.layerIndex);
}

/**
 * 收集数据
 */
PlatformMonitorInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
PlatformMonitorInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/platformMonitor/add", function(data){
        Feng.success("添加成功!");
        window.parent.PlatformMonitor.table.refresh();
        PlatformMonitorInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.platformMonitorInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PlatformMonitorInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/platformMonitor/update", function(data){
        Feng.success("修改成功!");
        window.parent.PlatformMonitor.table.refresh();
        PlatformMonitorInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.platformMonitorInfoData);
    ajax.start();
}

$(function() {

});
