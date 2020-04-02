/**
 * 
 */

var page;

function selectAllpage(){
	var data = $("#selectForm").serialize();
	$.ajax({
		url:"cust_selectByPage.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="";
			page = result;
			var i=1;
			$(result.list).each(function(){
				str+="<tr>";
				str+="<td>"+i+"</td>";
				str+="<td>"+this.f_name+"</td>";
				str+="<td>"+(this.f_sex==0?"男":"女")+"</td>";
				str+="<td>"+this.f_tel+"</td>";
				str+="<td>"+this.f_company+"</td>";
				str+="<td>"+this.ss+"</td>";
				str+="<td>"+(this.f_status==1?"可用":"不可用")+"</td>";
				str+="<td>"+this.f_credate+"</td>";
				str+="<td>"+this.f_creater+"</td>";
				str+="<td>"+(this.f_allotdate==null?"未分配":this.f_allotdate)+"</td>";
				str+="<td>"+(this.f_service==null?"未分配":this.f_service.f_name)+"</td>";
				str+="<td>";
				str+="<a href='customerView.html?f_id="+this.f_id+"' class='tablelink'>查看详情</a>&nbsp;&nbsp;";
				str+="<a href='customerUpdate.html?f_id="+this.f_id+"' class='tablelink'>修改</a>&nbsp;&nbsp;";
				if (this.f_status==1) {
					str+="<a href='javascript:void(0)' onclick=tipOpen('是否确认注销--"+this.f_name+"--信息？',"+this.f_id+",2) class='tablelink' >注销</a>&nbsp;&nbsp;";
					if (this.f_isallot==0) {
						str+="<a href='javascript:allottipOpen("+this.f_id+");' class='tablelink'>分配</a>&nbsp;&nbsp;";
					}
				} else {
					str+="<a href='javascript:void(0)' onclick=tipOpen('是否确认恢复--"+this.f_name+"--信息？',"+this.f_id+",1) class='tablelink' >恢复</a>";
				}
				str+=" </td>";
				str+="</tr>";
				i++;
			});
			$("tbody").html(str);
			pageButton();
		}
	});
}

function selectById() {
	$.ajax({
		url:"cust_selectById.action",
		data:{"f_id":getUrlParam("f_id")},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			$("cite:eq(0)").html(result.f_name);
			$("cite:eq(1)").html(result.f_sex==0?"男":"女");
			$("cite:eq(2)").html(result.f_company);
			$("cite:eq(3)").html(result.f_tel);
			$("cite:eq(4)").html(result.f_address);
			$("cite:eq(5)").html(result.ss);
			$("cite:eq(6)").html(result.f_view);
			$("cite:eq(7)").html(result.f_status==1?"可用":"不可用");
			$("cite:eq(8)").html(result.f_creater);
			$("cite:eq(9)").html(result.f_credate);
		}
	});
}
var city_id;
function update_selectById() {
	$.ajax({
		url:"cust_selectById.action",
		data:{"f_id":getUrlParam("f_id")},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			$("input[name=f_id]").val(result.f_id);
			$("input[name=f_name]").val(result.f_name);
			$("input[name=F_sex]:eq("+result.f_sex+")").prop("checked","true");
			$("input[name=F_company]").val(result.f_company);
			$("input[name=f_tel]").val(result.f_tel);
			$("input[name=F_address]").val(result.f_address);
			$("textarea[name=F_view]").val(result.f_view);
			$("select[name=F_status] option:eq("+(result.f_status-1)+")").prop("selected","selected");
			$("input[name=F_creater]").val(result.f_creater);
			$("input[name=F_credate]").val(result.f_credate);
			city_id=result.f_city.city_id;
			toSheng(result.ssid);
		}
	});
}
/**
 * 二级联动
 * @returns
 */

function toSheng(ssid) {
	$.ajax({
		url:"index_selectBySid.action",
		dataType:"json",
		async:true,
		type:"post",
		success:function(result){
			var str="<option value=''>请选择省份</option>";
			$(result).each(function(){
				if (ssid==this.pro_id) {
					str+="<option value='"+this.pro_id+"' selected >"+this.pro_name+"</option>";
				}else{
					str+="<option value='"+this.pro_id+"' >"+this.pro_name+"</option>";
				}
			});
			$("#ssid").html(str);
			toCity();
		}
	});
	
}
function toCity() {
	$.ajax({
		url:"index_selectBySSid.action",
		data:{"ssid":$("#ssid").val()},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value=''>请选择城市</option>";
			$(result).each(function(){
				if (city_id==this.city_id) {
					str+="<option value='"+this.city_id+"' selected >"+this.city_name+"</option>";
				} else {
					str+="<option value='"+this.city_id+"'>"+this.city_name+"</option>";
				}
				
			});
			$("#city").html(str);
		}
	});
}

function addClient() {
	var data = $("#client").serialize();
	$.ajax({
		url:"cust_addClient.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			if(result==true){
				window.location.href="customerList.html";
			}else{
				alert("添加失败！请重新添加！！！");
			}
			
		}
	});
}
function updateClient() {
	var data = $("#data").serialize();
	$.ajax({
		url:"cust_updateClient.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			if(result==true){
				window.location.href="customerList.html";
			}else{
				alert("修改失败！请重新添加！！！");
			}
			
		}
	});
}
function updateStatusClient() {
	var v=$("#valo").val();
	if (v==1) {
		recoverStatusClient();
	}else {
		cancelStatusClient();
	}
	
}
function cancelStatusClient() {
	$.ajax({
		url:"cust_cancelStatusClient.action",
		data:{"f_id":$("#ZXid").val(),"F_status":$("#valo").val()},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			tipClose();
			selectAllpage();
		}
	});
}
function recoverStatusClient() {
	$.ajax({
		url:"cust_recoverStatusClient.action",
		data:{"f_id":$("#ZXid").val(),"F_status":$("#valo").val()},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			tipClose();
			selectAllpage();
		}
	});
}


function selectAllpageBrowse(){
	var data = $("#selectForm").serialize();
	$.ajax({
		url:"cust_selectAllpageBrowse.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="";
			page = result;
			var i=1;
			$(result.list).each(function(){
				str+="<tr>";
				str+="<td>"+i+"</td>";
				str+="<td>"+this.f_name+"</td>";
				str+="<td>"+(this.f_sex==0?"男":"女")+"</td>";
				str+="<td>"+this.f_tel+"</td>";
				str+="<td>"+this.f_company+"</td>";
				str+="<td>"+this.ss+"</td>";
				str+="<td>"+this.f_allotdate+"</td>";
				str+="<td>"+(this.f_service==null?"未分配":this.f_service.f_name)+"</td>";
				str+="<td>";
				str+="<a href='customerView.html?f_id="+this.f_id+"' class='tablelink'>查看详情</a>&nbsp;&nbsp;";
				str+=" </td>";
				str+="</tr>";
				i++;
			});
			$("tbody").html(str);
			pageButton();
		}
	});
}
//分配

function selectPosition() {
	$.ajax({
		url:"cust_selectPosition.action",
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="";
			$(result).each(function(){
				str+="<option value='"+this.f_id+"' >"+this.f_name+"</option>";
			});
			$("#position").html(str);
			selectUserById();
		}
	});
}
function selectUserById() {
	var waId=$("#position").val();
	$.ajax({
		url:"cust_selectUserById.action",
		data:{"f_positionid.f_id":waId},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value='' >-请选择-</option>";
			$(result).each(function(){
				str+="<option value='"+this.f_id+"' >"+this.f_name+"</option>";
			});
			$("#user").html(str);
		}
	});
}

function updateClientF_isallot() {
	var data = $("#data").serialize();
	$.ajax({
		url:"cust_updateClientF_isallot.action",
		data:data,
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			allottipclose();
			selectAllpage();
		}
	});
}


function queryUser(){
	$.ajax({
		url:"queryUser.action",
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			$("#f_name").val(result.f_name);
		}
	});
}










/**
 * 时间转换函数
 * 毫秒----->年月日
 * @param second
 * @returns
 */
function timeToDate(data) {
    var d = new Date(data);//时间戳记得乘以1000再进行处理
    var year = d.getFullYear();
    var month = d.getMonth()+1;
    var date = d.getDate();
    var hour = d.getHours();
    var minute = d.getMinutes();
    var second = d.getSeconds();
    month=month<10?"0"+month:month;
    date=date<10?"0"+date:date;
    huor=hour<10?"0"+hour:hour;
    minute=minute<10?"0"+minute:minute;
    second=second<10?"0"+second:second;
    return year + "-" + month + "-" + date;
}
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
