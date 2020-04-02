/**
 * 
 */

var page;
function selectAllpage(){
	var data = $("#selectForm").serialize();
	$.ajax({
		url:"queryByPage.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="";
			page = result;
			var i=1;
			$(result.list).each(function(){
				str += "<tr><td>"+i+"</td>"+"<td>"+this.f_name+"</td>"+"<td>"+this.f_authId+"</td>"+"<td>"+this.f_url+"</td>"+"<td>"+(this.f_status==1?'正常':'禁用')+"</td>"+"<td><a href='moduleUpdate.html?id="+this.f_id+"' class='tablelink'>修改</a>&nbsp&nbsp&nbsp"+"<a href='javascript:void(0)' class='tablelink' "+"onclick='tipOpen(\"是否确认"+(this.f_status==1?'禁用':'启用')+"此模块？\",\""+this.f_id+"\","+this.f_status+")'>"+(this.f_status==1?'禁用':'启用')+"</a></td></tr>";
				i++;
			});
			$("tbody").html(str);
			$('.tablelist tbody tr:odd').addClass('odd');
			$(".message i:eq(0)").html(result.total);
			$(".message i:eq(1)").html(result.pageNum);
			pageButton();
		}
	});
}
function selectAllFmodule(){
	var data = $("#addForm").serialize();
	$.ajax({
		url:"queryAllFmodule.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var options="<option value='-1'>-------请选择-------</option>";
			$(result.list).each(function(){
				options += "<option value='"+this.f_name+"'>"+this.f_name+"</option>";
			});
			$("select[name=f_authId]").html(options);
		}
	});
}
function selectOne(){
	var f_id = getUrlParam("id");
	$.ajax({
		url:"queryOne.action",
		data:{"f_id":f_id},
		dataType:"json",
		type:"post",
		success:function(result){
			$(result.list).each(function(){
				$("input[name='f_id']").val(this.f_id);
				$("input[name='f_name']").val(this.f_name);
				$("select[name=f_authId] option[value='"+this.f_authId+"']").prop("selected",true);
				$("input[name='f_url']").val(this.f_url);
			});
		}
	});
}
function selectpageone(){
	var name = getUrlParam1("name");
	$.ajax({
		url:"querypageOne.action",
		data:{"f_name":name},
		dataType:"json",
		type:"post",
		success:function(result){
			$(result.list).each(function(){
				$("#a").text(this.f_name);
				$("#b").text(this.f_authId);
				$("#c").text(this.f_url);
				$("#d").text((this.f_status==1?'正常':'禁用'));
			});
		}
	});
}
function getUrlParam1(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return decodeURI(r[2]); return null; //返回参数值
}
function tipOpen(content,id,status) {
	$(".sure").attr("onclick","updateStatus('"+id+"','"+status+"')");
	$(".tipright p").text(content);
	$("#tip").fadeIn(200);
}
function tipClose() {
	$("#tip").fadeOut(200);
}
function toPage(pageNow){
	$("input[name='pageNum']").val(pageNow);
	selectAllpage();
}
function addModule(){
	var data = $("#addForm").serialize();
	$.ajax({
		url:"addModule.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result==0){
				alert("添加失败");
				window.location.reload();
			}else{
				alert("添加成功");
				window.location.href="moduleList.html";
			}
		}
	});
}
function updateStatus(id,status){
	if(status==1){
		$.ajax({
			url:"cancelStatus.action",
			data:{"f_id":id,"f_status":status},
			dataType:"json",
			type:"post",
			success:function(result){
				tipClose();
				window.location.href="moduleList.html";
			}
		});
	}else{
		$.ajax({
			url:"recoverStatus.action",
			data:{"f_id":id,"f_status":status},
			dataType:"json",
			type:"post",
			success:function(result){
				tipClose();
				window.location.href="moduleList.html";
			}
		});
	}
}
function updateModule(){
	var data = $("#updateForm").serialize();
	$.ajax({
		url:"updateModule.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result==0){
				alert("修改失败");
				window.location.reload();
			}else{
				alert("修改成功");
				window.location.href="moduleList.html";
			}
		}
	});
}
