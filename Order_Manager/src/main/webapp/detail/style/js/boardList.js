/* 退桌 */
function returnTa(id,status){
    var ids;
    if(status=="0"){
        if(confirm('确实要预定该桌吗?')) {
            $.post("../planned.do", {ids:id},
                function(data){
                    if(data.success){
                        alert(data.message);
                    }else{
                        alert(data.message);
                    }
                    window.location.reload();
                },"json");
        }
    }else{
        if(confirm('确实要退桌吗?')) {
            $.post("../returnTable.do", {ids:id},
                function(data){
                    if(data.success){
                        alert(data.message);
                    }else{
                        alert(data.message);
                    }
                    window.location.reload();
                },"json");
        }
    }
}

/* 删除餐桌 */
function deleteTa(id){
    if(confirm('确定要删除该餐桌吗？')){
        $.post("../deleteTable.do", {id:id},
            function(data){
                if(data.success){
                    alert(data.message);
                }else{
                    alert(data.message);
                }
                window.location.reload();
            },"json");
    }
}

/* 每页条数 */
var pageAm;
/* 总页数 */
var dataTo;
function loadPage(page,keywords) {

    var arr = new Array();
    arr[0] = "空闲";
    arr[1] = "预定";
    $.ajax({
        url: "../list.do",
        dataType: "json",
        type: "post",
        async:false,
        data: {pages: page, keyword: keywords},
        success: function (data) {
            pageAm = data.rows
            dataTo = data.total;
            var trs = "";
            $.each(data.list, function (key, value) {
                trs += "<tr>" + "<td>" + value.id + "</td>" + "<td>" + value.tableName + "</td>" + "<td>" + arr[value.status] + "</td>"
                    + "<td>" + value.creatTime + "</td>" + "<td>" + "<a href='#' onclick=returnTa" + "(" + value.id + "," + value.status + ")" + ">" + (value.status == 0 ? '预定' : '退桌') + "</a>"
                    + "&nbsp" + "<a href='#' onclick=deleteTa" + "(" + value.id + ")" + ">" + "删除" + "</a>" + "</td>" + "</tr>" + "</br>";
            });
            document.getElementById('TableData').innerHTML = trs;
        }
    });
}
/* 分页 */
window.onload = function () {
    /* 获取搜索内容 */
    var keywords = document.getElementById('word').value
    /* 如果当前存在搜索关键字*/
    if(keywords!=""&&keywords!=null){
        loadPage(1,keywords);
    }else{
        loadPage(1,"");
    }
    var pageTo = Math.ceil(dataTo/pageAm);
    new myPagination({
        id: 'pagination',
        curPage:1, //初始页码
        pageTotal: pageTo, //总页数
        pageAmount: pageAm,  //每页多少条
        dataTotal: dataTo, //总共多少条数据
        pageSize: 15, //可选,分页个数
        showPageTotalFlag:true, //是否显示数据统计
        showSkipInputFlag:true, //是否支持跳转
        getPage: function (page) {
            loadPage(page,keywords);
        }
    });
}