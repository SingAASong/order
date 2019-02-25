window.onload = function () {
    $.get("../cook/findAll.do",
        function(data){
            var str="";
            $.each(data, function (key, value) {
                str+="<option value="+value.id+">"+value.cookName+"</option>";
                console.log(str)
            });
            document.getElementById("cid").innerHTML="<option>*请选择*</option>"+str;
        },"json");
}

/* 获取选中菜系并将id赋值隐藏域 */
function dianji(){
    var options=$("#cid option:selected");
    document.getElementById("sub1").value=options.val();
}

function save(){
    // 上传设置
    var option = {
        // 规定把请求发送到那个URL
        url: "../food/save.do",
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
            if(confirm('继续添加？')){
                window.location.reload();
            }else{
                window.location.href="foodList.html";
            }

        }
    };
    $("#subform	").ajaxSubmit(option);

}

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
            $("#allUrl").attr("src", data.path);
            document.getElementById("refile1").value=data.path;

        }
    };

    $("#subform	").ajaxSubmit(options);
}