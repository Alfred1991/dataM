/**
 * 初始化测试详情对话框
 */
var AmbariInfoDlg = {
    ambariInfoData : {}
};

/**
 * 清除数据
 */
AmbariInfoDlg.clearData = function() {
    this.ambariInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AmbariInfoDlg.set = function(key, val) {
    this.ambariInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AmbariInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AmbariInfoDlg.close = function() {
    parent.layer.close(window.parent.Ambari.layerIndex);
}

/**
 * 收集数据
 */
AmbariInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
AmbariInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ambari/add", function(data){
        Feng.success("添加成功!");
        window.parent.Ambari.table.refresh();
        AmbariInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ambariInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AmbariInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ambari/update", function(data){
        Feng.success("修改成功!");
        window.parent.Ambari.table.refresh();
        AmbariInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ambariInfoData);
    ajax.start();
}

$(function() {

});
