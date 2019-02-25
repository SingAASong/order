/*获取URL传过来的信息*/
function GetRequest() {
		var url = location.search; //获取url中"?"符后的字串
		var theRequest = new Object();
		if(url.indexOf("?") != -1) {
			var str = url.substr(1);
			strs = str.split("&");
			for(var i = 0; i < strs.length; i++) {
				theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
			}
		}
		return theRequest;
	};
/* 获取选中菜系并将id赋值隐藏域 */
function dianji(){
	var options=$("#cid option:selected");
	document.getElementById("saveId").value=options.val();
}
//页面加载完毕事件  DOM（文档对象模型） 已经加载，并且页面（包括图像）已经完全呈现时，会发生 ready 事件。
$(document).ready(function(){
	var data=GetRequest().id;
	//异步获取下拉框
	$.get("../cook/findAll.do",
			  function(data){
					var str="";
					var obj=JSON.parse(data);
					$.each(obj, function (key, value) {
			    	str+="<option value="+value.id+">"+value.cookName+"</option>";
					});
			    	document.getElementById("cid").innerHTML=str;
			  },"json");
	
	//数据回显
	if(data!=null&&data!=""){
		$.get("../food/findById.do",{id:data},
				  function(data){
					$("#cid").val(data.cookId);
					$("#saveId").val(data.cookId);
				    $("#foodName").val(data.foodName);
				    $("#price").val(data.price);
				    $("#vipPrice").val(data.vipPrice);
				    $("#company").val(data.company);
				    $("#Id").val(data.id);
				    // 图片显示地址
					$("#allUrl").attr("src", data.files);
				  },"json");
	}else{
		window.location.href="cuisineList.html";
	}
});
//图片文件上传
function uploadPic() {
	// 上传设置
	var options = {
			// 规定把请求发送到那个URL
			url: "../food/uploadPic.do",
			// 请求方式
			type: "post",
			// 服务器响应的数据类型
			dataType: "json",
			// 请求成功时执行的回调函数
			success: function(data, status, xhr) {
				// 图片显示地址
				$("#allUrl").attr("src",data.path);
				document.getElementById("refile1").value=data.path;
			}
	};
	$("#subform").ajaxSubmit(options);
}

function update(){
	// 上传设置
	var option = {
			// 规定把请求发送到那个URL
			url: "../food/update.do",
			// 请求方式
			type: "post",
			// 服务器响应的数据类型
			dataType: "json",
			// 请求成功时执行的回调函数
			success: function(data, status, xhr) {
				if(data.success){
					alert(data.message)
				}else{
					alert(data.message)
				}
				window.location.href="foodList.html";
			}
	};
		$("#subform").ajaxSubmit(option);
}