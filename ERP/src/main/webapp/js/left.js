/**
 * 
 */


function selectAllModule(){
	var data = $("#updateForm").serialize();
	$.ajax({
		url:"queryAllModule.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			$(result.list).each(function(){
				if(this.f_authId=="营销管理"){
					var str="";
					str += "<li><cite></cite>";
					str += "<a href='"+this.f_url+"' value='"+this.f_id+"' target='rightFrame'>"+this.f_name+"</a>";
                    str += "<i></i></li>";
					$("#yx1").append(str);
				}
				if(this.f_authId=="仓库管理"){
					var str="";
					str += "<li><cite></cite>";
					str += "<a href='"+this.f_url+"' value='"+this.f_id+"' target='rightFrame'>"+this.f_name+"</a>";
                    str += "<i></i></li>";
					$("#ck1").append(str);
				}
				if(this.f_authId=="采购管理"){
					var str="";
					str += "<li><cite></cite>";
					str += "<a href='"+this.f_url+"' value='"+this.f_id+"' target='rightFrame'>"+this.f_name+"</a>";
                    str += "<i></i></li>";
					$("#cg1").append(str);
				}
				if(this.f_authId=="数据统计"){
					var str="";
					str += "<li><cite></cite>";
					str += "<a href='"+this.f_url+"' value='"+this.f_id+"' target='rightFrame'>"+this.f_name+"</a>";
                    str += "<i></i></li>";
					$("#tj1").append(str);
				}
				if(this.f_authId=="系统管理"){
					var str="";
					str += "<li><cite></cite>";
					str += "<a href='"+this.f_url+"' value='"+this.f_id+"' target='rightFrame'>"+this.f_name+"</a>";
                    str += "<i></i></li>";
					$("#xt1").append(str);
				}
			});
			queryUser();
		}
	});
}
function queryUser(){
	var data = $("#updateForm").serialize();
	$.ajax({
		url:"queryUser.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			selectOneModuleLeft(result);
		}
	});
}
function selectOneModuleLeft(x){
	var f_positionid = x;
	$.ajax({
		url:"selectOneModuleLeft.action",
		data:{"f_positionid.f_id":f_positionid},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			for(var i=0;i<result.list.length;i++){
                $.each($(".leftmenu a"),function (j,e) {
                    if(result.list[i].f_authId == $(e).attr("value")){
                        $(e).attr("class","yy");
                    }
                });
            }
			$.each($(".leftmenu a"),function (j,e) {
				if ($(e).attr('class') != 'yy') {
					$(e).parent().remove();
				}
            });
			$.each($(".leftmenu ul"),function (j,e) {
				if($(e).has("li").length <= 0){
					$(e).parent().remove();
				}
            });
		}
	});
}