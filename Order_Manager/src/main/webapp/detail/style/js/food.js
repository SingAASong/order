/* 每页条数 */
var pageAm;
/* 总页数 */
var dataTo;
function load(page,keywords){
    $.ajaxSetup({async : false});
	$.post("../food/list.do",{pages:page,keyword:keywords},
		function(data){
		  pageAm=data.rows
		  dataTo=data.total;
            var trs="";
		  $.each(data.list, function (key, value) {
                trs+="<tr>"+"<td >"+value.id+"</td>"+"<td>"+value.foodName+"</td>"+
					"<td>"+value.cookName+"</td>"+"<td>"+value.price+"</td>"+"<td>"+value.vipPrice+"</td>"+
					"<td>"+"<a href=updateFood.html?id"+"="+value.id+">"+"更新"+"</a>"+"&nbsp"+
					"<a href='#' onclick=delConfirm("+value.id+")"+">"+"删除"+"</a>"+"</td>"+"</tr>"+"</br>";
	});
		  document.getElementById("TableDa").innerHTML=trs;
	},"json");
}
$(document).ready(function(){
	/* 获取搜索内容 */
	var keywords = document.getElementById('word').value
	/* 如果当前存在搜索关键字*/
	if(keywords!=""&&keywords!=null){
		load(1,keywords);
	}else{
		load(1,"");
	}
	var pageTo = Math.ceil(dataTo/pageAm);
   	 new myPagination({
        id: 'pagination',
        curPage:1, //初始页码 
        pageTotal: pageTo, //总页数
		pageAmount: pageAm,  //每页多少条
        dataTotal: dataTo, //总共多少条数据
		pageSize: 5, //可选,分页个数
        showPageTotalFlag:true, //是否显示数据统计
        showSkipInputFlag:true, //是否支持跳转
        getPage: function (page) {
        	load(page,keywords);
        }
    });
});

function delConfirm(ids){
	if(confirm('确实要删除吗?')) {
	$.get("../food/delete.do",{id:ids},
		function(data){
		if(data.success){
			alert(data.message)
		}else{
			alert(data.message)
		}
		window.location.reload();
		},"json");
	}
}
