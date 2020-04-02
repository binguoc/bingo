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
				var jt = getMyDate((this.f_jointime==null?" ":this.f_jointime));
				var lt = getMyDate((this.f_leavetime==null?" ":this.f_leavetime));
				var bd = getMyDate(this.f_birthday);
				var birthday_time=bd.split("-")
                var birthYear = birthday_time[0];
                var d= new Date();
                var nowYear=d.getFullYear();
                var age=nowYear-birthYear;
				str += "<tr>"
				str += "<td>"+i+"</td>"
				str += "<td>"+this.f_id+"</td>"
				str += "<td>"+this.f_name+"</td>"
				str += "<td>"+this.f_tel+"</td>"
				str += "<td>"+(this.f_positionid.dept==null?" ":this.f_positionid.dept.f_name)+"</td>"
				str += "<td>"+(this.f_positionid==null?" ":this.f_positionid.f_name)+"</td>"
				str += "<td>"+(this.f_sex==1?"男":"女")+"</td>"
				str += "<td>"+age+"</td>"
				str += "<td>"+(this.f_status==1?"在职":"离职")+"</td>"
				str += "<td>"+jt+"</td>"
				str += "<td>"+(this.f_leavetime==null?" ":lt)+"</td>"
				str += "<td>"
				str += "<a href='userUpdate.html?id="+this.f_z+"' class='tablelink'>修改</a>&nbsp&nbsp&nbsp"
				str += "<a href='javascript:void(0)' class='tablelink' onclick='tipOpen(\"您是否确认此员工"+(this.f_status==1?'离职':'恢复在职')+"吗？\",\""+this.f_z+"\","+this.f_status+")'>"+(this.f_status==1?"离职":"在职")+"</a>&nbsp&nbsp&nbsp"
				str += "<a href='javascript:void(0)' class='tablelink' onclick='tipOpen1(\"您确定给此员工重置密码吗？\",\""+this.f_z+"\")'>重置密码</a>"
				str += "</td>"
				str += "</tr>"
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

function getMyDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间
    return oTime;
};
//补0操作
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}
function selectAllDept(){
	var data = $("#addForm").serialize();
	$.ajax({
		url:"queryAllDept.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var options="<option value='-1'>请选择部门</option>";
			$(result.list).each(function(){
				options += "<option value='"+this.f_id+"'>"+this.f_name+"</option>";
			});
			$("select[name=f_positionid\\.dept\\.f_id]").html(options);
		}
	});
}
function selectPosition(f_id){
	$.ajax({
		url:"queryPosition.action",
		data:{"f_positionid.dept.f_id":f_id},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var options="<option value='-1'>请选择职位</option>";
			$(result.list).each(function(){
				options += "<option value='"+this.f_id+"'>"+this.f_name+"</option>";
			});
			$("select[name=f_positionid\\.f_id]").html(options);
		}
	});
}
function selectOne(){
	var f_id = getUrlParam("id");
	$.ajax({
		url:"queryOne.action",
		data:{"f_z":f_id},
		dataType:"json",
		type:"post",
		success:function(result){
			$(result.list).each(function(){
				var bd = getMyDate((this.f_birthday==null?" ":this.f_birthday));
				$("input[name='f_z']").val(this.f_z);
				$("input[name='f_id']").val(this.f_id);
				$("input[name='f_name']").val(this.f_name);
				$("input[name='f_password']").val(this.f_password);
				$("input[name='f_sex'][value="+this.f_sex+"]").attr("checked",true);
				$("input[name='f_tel']").val(this.f_tel);
				$("input[name='f_birthday']").val(bd);
				$("select[name='f_status'] option[value='"+(this.f_status==null?" ":this.f_status)+"']").prop("selected",true);
				$("select[name=f_positionid\\.dept\\.f_id] option[value='"+(this.f_positionid.dept==null?" ":this.f_positionid.dept.f_id)+"']").prop("selected",true);
				selectPosition(this.f_positionid.dept.f_id);
				$("select[name=f_positionid\\.f_id] option[value='"+(this.f_positionid==null?" ":this.f_positionid.f_id)+"']").prop("selected",true);
			});
		}
	});
}
function tipOpen(content,id,status) {
	$(".sure").attr("onclick","updateStatus('"+id+"','"+status+"')");
	$(".tipright p").text(content);
	$("#tip").fadeIn(200);
}
function tipOpen1(content,id) {
	$(".sure").attr("onclick","updateUserPwd('"+id+"')");
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
function addUser(){
	var data = $("#addForm").serialize();
	$.ajax({
		url:"addUser.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result==0){
				alert("添加失败");
				window.location.reload();
			}else{
				alert("添加成功");
				window.location.href="userList.html";
			}
		}
	});
}
function updateStatus(id,status){
	if(status==1){
		$.ajax({
			url:"cancelStatus.action",
			data:{"f_z":id,"f_status":status},
			dataType:"json",
			type:"post",
			success:function(result){
				tipClose();
				window.location.href="userList.html";
			}
		});
	}else{
		$.ajax({
			url:"recoverStatus.action",
			data:{"f_z":id,"f_status":status},
			dataType:"json",
			type:"post",
			success:function(result){
				tipClose();
				window.location.href="userList.html";
			}
		});
	}
}
function updateUserPwd(id){
	$.ajax({
		url:"updateUserPwd.action",
		data:{"f_z":id},
		dataType:"json",
		type:"post",
		success:function(result){
			tipClose();
			window.location.href="userList.html";
		}
	});
}
function updateUser(){
	var data = $("#updateForm").serialize();
	$.ajax({
		url:"updateUser.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result==0){
				alert("修改失败");
				window.location.reload();
			}else{
				alert("修改成功");
				window.location.href="userList.html";
			}
		}
	});
}
