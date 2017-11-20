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
        {title: '监控id', field: 'monitor_id', visible: false, align: 'center', valign: 'middle'},
        {title: '告警id', field: 'definition_id',align: 'center', valign: 'middle'},
        {title: '告警定义名称', field: 'definition_name', align: 'center', valign: 'middle', sortable: true},
        {title: '服务名称', field: 'service_name', align: 'center', valign: 'middle'},
        {title: '组件名称', field: 'component_name', align: 'center', valign: 'middle', sortable: true},
        {title: '告警周期(分)', field: 'schedule_interval', align: 'center', valign: 'middle', sortable: true}];
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
    init();
    var defaultColunms = PlatformMonitor.initColumn();
    var table = new BSTable(PlatformMonitor.id, "/platformMonitor/list", defaultColunms);
    table.setPaginationType("server");
    PlatformMonitor.table = table.init();
});



function init() {

    var BootstrapTable = $.fn.bootstrapTable.Constructor;
    BootstrapTable.prototype.onSort = function (event) {
        var $this = event.type === "keypress" ? $(event.currentTarget) : $(event.currentTarget).parent(),
            $this_ = this.$header.find('th').eq($this.index()),
            sortName = this.header.sortNames[$this.index()];

        this.$header.add(this.$header_).find('span.order').remove();

        if (this.options.sortName === $this.data('field')) {
            this.options.sortOrder = this.options.sortOrder === 'asc' ? 'desc' : 'asc';
        } else {
            this.options.sortName = sortName || $this.data('field');
            this.options.sortOrder = $this.data('order') === 'asc' ? 'desc' : 'asc';
        }
        this.trigger('sort', this.options.sortName, this.options.sortOrder);

        $this.add($this_).data('order', this.options.sortOrder);

        // Assign the correct sortable arrow
        this.getCaret();

        if (this.options.sidePagination === 'server') {
            this.initServer(this.options.silentSort);
            return;
        }

        this.initSort();
        this.initBody();
    };
    BootstrapTable.prototype.getCaret = function () {
        var that = this;

        $.each(this.$header.find('th'), function (i, th) {
            var sortName = that.header.sortNames[i];
            $(th).find('.sortable').removeClass('desc asc').addClass((sortName || $(th).data('field')) === that.options.sortName ? that.options.sortOrder : 'both');
        });
    };
}