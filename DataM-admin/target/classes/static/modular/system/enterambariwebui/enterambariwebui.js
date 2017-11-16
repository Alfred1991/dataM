/**
 * 进入ambari webui管理初始化
 */
var Enterambariwebui = {
    id: "EnterambariwebuiTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Enterambariwebui.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Enterambariwebui.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Enterambariwebui.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加进入ambari webui
 */
Enterambariwebui.openAddEnterambariwebui = function () {
    var index = layer.open({
        type: 2,
        title: '添加进入ambari webui',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/enterambariwebui/enterambariwebui_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看进入ambari webui详情
 */
Enterambariwebui.openEnterambariwebuiDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '进入ambari webui详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/enterambariwebui/enterambariwebui_update/' + Enterambariwebui.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除进入ambari webui
 */
Enterambariwebui.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/enterambariwebui/delete", function (data) {
            Feng.success("删除成功!");
            Enterambariwebui.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("enterambariwebuiId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询进入ambari webui列表
 */
Enterambariwebui.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Enterambariwebui.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Enterambariwebui.initColumn();
    var table = new BSTable(Enterambariwebui.id, "/enterambariwebui/list", defaultColunms);
    table.setPaginationType("client");
    Enterambariwebui.table = table.init();
});
