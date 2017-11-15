/**
 * 进入ambari webui权限管理管理初始化
 */
var Rolesinambarimanager = {
    id: "RolesinambarimanagerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Rolesinambarimanager.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: 'dataM账号id', field: 'dataM_account_id', align: 'center', valign: 'middle', sortable: true},
        {title: 'dataM账号', field: 'dataM_account', align: 'center', valign: 'middle', sortable: true},
        {title: 'ambari账号id', field: 'ambari_user_id', align: 'center', valign: 'middle', sortable: true},
        {title: 'ambari账号', field: 'ambari_user_name', align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Rolesinambarimanager.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Rolesinambarimanager.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加进入ambari webui权限管理
 */
Rolesinambarimanager.openAddRolesinambarimanager = function () {
    var index = layer.open({
        type: 2,
        title: '添加进入ambari webui权限管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/rolesinambarimanager/rolesinambarimanager_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看进入ambari webui权限管理详情
 */
Rolesinambarimanager.openRolesinambarimanagerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '进入ambari webui权限管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/rolesinambarimanager/rolesinambarimanager_update/' + Rolesinambarimanager.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除进入ambari webui权限管理
 */
Rolesinambarimanager.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/rolesinambarimanager/delete", function (data) {
            Feng.success("删除成功!");
            Rolesinambarimanager.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("rolesinambarimanagerId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询进入ambari webui权限管理列表
 */
Rolesinambarimanager.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Rolesinambarimanager.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Rolesinambarimanager.initColumn();
    var table = new BSTable(Rolesinambarimanager.id, "/rolesinambarimanager/list", defaultColunms);
    table.setPaginationType("client");
    Rolesinambarimanager.table = table.init();
});
