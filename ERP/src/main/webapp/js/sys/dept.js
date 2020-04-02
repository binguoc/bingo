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
				str += "<tr><td>"+i+"</td>"+"<td>"+this.f_id+"</td>"+"<td>"+this.f_name+"</td>"+"<td>"+(this.f_status==1?'正常':'不正常')+"</td>"+"<td><a href='deptUpdate.html?id="+this.f_id+"' class='tablelink'>修改</a>&nbsp&nbsp&nbsp"+"<a href='javascript:void(0)' class='tablelink' "+"onclick='tipOpen(\"是否确认"+(this.f_status==1?'注销':'恢复')+"此条信息？\",\""+this.f_id+"\","+this.f_status+")'>"+(this.f_status==1?'注销':'恢复')+"</a></td></tr>";
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
				$("input[name='f_z']").val(this.f_id);
				$("input[name='f_name']").val(this.f_name);
			});
		}
	});
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
function addDept(){
	var data = $("#addForm").serialize();
	$.ajax({
		url:"addDept.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result==0){
				alert("添加失败");
				window.location.reload();
			}else{
				alert("添加成功");
				window.location.href="deptList.html";
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
				window.location.href="deptList.html";
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
				window.location.href="deptList.html";
			}
		});
	}
}
function updateDept(){
	var data = $("#updateForm").serialize();
	$.ajax({
		url:"updateDept.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result==0){
				alert("修改失败");
				window.location.reload();
			}else{
				alert("修改成功");
				window.location.href="deptList.html";
			}
		}
	});
}
