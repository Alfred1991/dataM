/**
 * 平台监控管理管理初始化
 */
var PlatformMonitor = {
    id: "PlatformMonitorTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
PlatformMonitor.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
PlatformMonitor.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        PlatformMonitor.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加平台监控管理
 */
PlatformMonitor.openAddPlatformMonitor = function () {
    var index = layer.open({
        type: 2,
        title: '添加平台监控管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/platformMonitor/platformMonitor_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看平台监控管理详情
 */
PlatformMonitor.openPlatformMonitorDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '平台监控管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/platformMonitor/platformMonitor_update/' + PlatformMonitor.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除平台监控管理
 */
PlatformMonitor.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/platformMonitor/delete", function (data) {
            Feng.success("删除成功!");
            PlatformMonitor.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("platformMonitorId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询平台监控管理列表
 */
PlatformMonitor.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    PlatformMonitor.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = PlatformMonitor.initColumn();
    var table = new BSTable(PlatformMonitor.id, "/platformMonitor/list", defaultColunms);
    table.setPaginationType("client");
    PlatformMonitor.table = table.init();
});
