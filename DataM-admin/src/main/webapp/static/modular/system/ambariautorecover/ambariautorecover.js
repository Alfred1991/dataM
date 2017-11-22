/**
 * ambari自动恢复管理初始化
 */
var Ambariautorecover = {
    id: "AmbariautorecoverTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Ambariautorecover.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '监控id', field: 'monitor_id', align: 'center', valign: 'middle', sortable: true},
        {title: '告警定义id', field: 'definition_id', align: 'center', valign: 'middle', sortable: true},
        {title: '服务名称', field: 'service_name', align: 'center', valign: 'middle', sortable: true},
        {title: '组件名称', field: 'component_name', align: 'center', valign: 'middle', sortable: true},
        {title: '主机名', field: 'host_name', align: 'center', valign: 'middle', sortable: true},
        {title: '告警id', field: 'alert_id', align: 'center', valign: 'middle', sortable: true},
        {title: '告警类型', field: 'alert_type', align: 'center', valign: 'middle', sortable: true},
        {title: '告警时间', field: 'alert_time', align: 'center', valign: 'middle', sortable: true},
        {title: '发送告警次数', field: 'alert_send_count', align: 'center', valign: 'middle', sortable: true},
        {title: '最后一次发送告警时间', field: 'alert_send_last_time', align: 'center', valign: 'middle', sortable: true},
        {title: '告警恢复id', field: 'alert_recover_id', align: 'center', valign: 'middle', sortable: true},
        {title: '尝试自动恢复次数', field: 'auto_recover_retry_count', align: 'center', valign: 'middle', sortable: true},
        {title: '最后一次尝试自动恢复时间', field: 'auto_recover_last_time', align: 'center', valign: 'middle', sortable: true},
        {title: '恢复时间', field: 'recover_time', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Ambariautorecover.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Ambariautorecover.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加ambari自动恢复
 */
Ambariautorecover.openAddAmbariautorecover = function () {
    var index = layer.open({
        type: 2,
        title: '添加ambari自动恢复',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/ambariautorecover/ambariautorecover_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看ambari自动恢复详情
 */
Ambariautorecover.openAmbariautorecoverDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'ambari自动恢复详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/ambariautorecover/ambariautorecover_update/' + Ambariautorecover.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除ambari自动恢复
 */
Ambariautorecover.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/ambariautorecover/delete", function (data) {
            Feng.success("删除成功!");
            Ambariautorecover.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("ambariautorecoverId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询ambari自动恢复列表
 */
Ambariautorecover.search = function () {
    var queryData = {};
    queryData['definition_id'] = $("#definition_id").val();
    queryData['service_name'] = $("#service_name").val();
    queryData['component_name'] = $("#component_name").val();
    queryData['host_name'] = $("#host_name").val();
    queryData['alert_id'] = $("#alert_id").val();
    queryData['alert_time_begin'] = $("#alert_time_begin").val();
    queryData['alert_time_end'] = $("#alert_time_end").val();
    Ambariautorecover.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Ambariautorecover.initColumn();
    var table = new BSTable(Ambariautorecover.id, "/ambariautorecover/list", defaultColunms);
    table.setPaginationType("client");
    Ambariautorecover.table = table.init();
});
