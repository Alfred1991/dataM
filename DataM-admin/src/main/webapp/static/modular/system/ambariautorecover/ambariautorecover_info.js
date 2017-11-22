/**
 * 初始化ambari自动恢复详情对话框
 */
var AmbariautorecoverInfoDlg = {
    ambariautorecoverInfoData : {}
};

/**
 * 清除数据
 */
AmbariautorecoverInfoDlg.clearData = function() {
    this.ambariautorecoverInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AmbariautorecoverInfoDlg.set = function(key, val) {
    this.ambariautorecoverInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AmbariautorecoverInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AmbariautorecoverInfoDlg.close = function() {
    parent.layer.close(window.parent.Ambariautorecover.layerIndex);
}

/**
 * 收集数据
 */
AmbariautorecoverInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
AmbariautorecoverInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ambariautorecover/add", function(data){
        Feng.success("添加成功!");
        window.parent.Ambariautorecover.table.refresh();
        AmbariautorecoverInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ambariautorecoverInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AmbariautorecoverInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ambariautorecover/update", function(data){
        Feng.success("修改成功!");
        window.parent.Ambariautorecover.table.refresh();
        AmbariautorecoverInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ambariautorecoverInfoData);
    ajax.start();
}

$(function() {

});
