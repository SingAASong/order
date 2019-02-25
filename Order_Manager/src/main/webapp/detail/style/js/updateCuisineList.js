function save(){
    $.post("../cook/save.do",$("#form1").serialize(),
        function(data){
            if(data.success){
                alert(data.message);
            }else{
                alert(data.message);
            }
            window.location.href="cuisineList.html";
        },"json");
}
$(document).ready(function(){
    var data = GetRequest().id;
    if(data!=null&&data!=""){
        $.get("../cook/find.do",{id:data},
            function(data){
                $("#cookid").val(data.id);
                $("#cookname").val(data.cookName);
            },"json");
    }else{
        window.location.href="cuisineList.html";
    }
});

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