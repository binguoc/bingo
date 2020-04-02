var page;

var dalNum=0;
function addDal() {
	a=0;
	b=0;
	c=0;
	var str="<tr>";
	str+="<td>"+(dalNum+1)+"<input type='hidden' name='list["+dalNum+"].order.f_did' value='"+$("#did").val()+"'/><input class='pid' type='hidden' name='list["+dalNum+"].f_id' value=''/></td>";
	str+="<td><select class='brand' onchange='selectAllWarestype("+dalNum+")'><option>请选择</option></select></td>";
	str+="<td><select class='warestype' onchange='selectAllWares("+dalNum+")'' ><option>请选择</option></select></td>";
	str+="<td><select class='wares' name='list["+dalNum+"].wares.waId'  onchange='selectAllFirm("+dalNum+")'><option>请选择</option></select></td>";
	str+="<td><select class='firm' name='list["+dalNum+"].firm.fiId' onblur='toYan("+dalNum+")' ><option>请选择</option></select></td>";
	str+="<td><input type='number' class='count' name='list["+dalNum+"].f_count' onblur='autoSum("+dalNum+")'/></td>";
	str+="<td><input type='text' name='list["+dalNum+"].f_status' value='台' readonly='readonly'/></td>";
	str+="<td><input type='number' class='auditor' name='list["+dalNum+"].f_auditor' onblur='autoSum("+dalNum+")'/></td>";
	str+="<td><input type='text' class='SumMoney' name='list["+dalNum+"].f_Money' readonly='readonly'/></td>";
	str+="</tr>";
	$(".tablelist tbody").append(str);
	selectAllBrand2(dalNum);
	dalNum++;
	if (dalNum-1==-1) {
		selectAllBrand();
	}
}
function selectAllBrand2(v){
	$.ajax({
		url:"order_selectAllBrand.action",
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value='' >-请选择-</option>";
			$(result).each(function(){
				str+="<option value='"+this.brId+"' >"+this.brName+"</option>";
			});
			$(".brand:eq("+v+")").html(str);
		}
	});
}
function delDal() {
	if (dalNum-1>-1) {
	$(".tablelist tbody tr").last().remove();
	dalNum--;
	autoSum(0);
	}
}




function selectById() {
	$.ajax({
		url:"order_selectById.action",
		data:{"f_did":getUrlParam("id")},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			$("#id").val(result.f_id);
			$("#did").val(result.f_did);
			$("#client").val(result.client.f_name);
			$("#company").val(result.f_company);
			$("#dpeople").val(result.f_dpeople.f_name);
			$("#dpeid").val(result.f_dpeople.f_id);
			$("#f_Moneysum").val(result.f_Moneysum);
			selectAllClient(result.client.f_id);
			selectDalByDId(result.f_did);
		}
	});
}


var a;
var b;
var c;
function selectDalByDId(f_did) {
	$.ajax({
		url:"order_selectDalByDId.action",
		data:{"order.f_did":f_did},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			$(result).each(function(){
				var str="";
				str+="<tr>";
				str+="<td>"+(dalNum+1)+"<input type='hidden' name='list["+dalNum+"].order.f_did' value='"+$("#did").val()+"'/><input class='pid' type='hidden' name='list["+dalNum+"].f_id' value='"+this.f_id+"'/></td>";
				str+="<td><select class='brand' onchange='selectAllWarestype("+dalNum+")'><option>请选择</option></select></td>";
				str+="<td><select class='warestype' onchange='selectAllWares("+dalNum+")'' ><option>请选择</option></select></td>";
				str+="<td><select class='wares' name='list["+dalNum+"].wares.waId'  onchange='selectAllFirm("+dalNum+")'><option>请选择</option></select></td>";
				str+="<td><select class='firm' name='list["+dalNum+"].firm.fiId' onblur='toYan("+dalNum+")' ><option>请选择</option></select></td>";
				str+="<td><input type='number' class='count' name='list["+dalNum+"].f_count' onblur='autoSum("+dalNum+")'value='"+this.f_count+"'/></td>";
				str+="<td><input type='text' name='list["+dalNum+"].f_status' value='"+this.f_status+"' readonly='readonly'/></td>";
				str+="<td><input type='number' class='auditor' name='list["+dalNum+"].f_auditor' onblur='autoSum("+dalNum+")' value='"+this.f_auditor+"'/></td>";
				str+="<td><input type='text' class='SumMoney' name='list["+dalNum+"].f_Money' readonly='readonly' value='"+this.f_Money+"'/></td>";
				str+="</tr>";
				$(".tablelist tbody").append(str);
				a=this.typeid;
				b=this.wares==null?0:this.wares.waId;
				c=this.firm==null?0:this.firm.fiId;
				selectAllBrand(dalNum,this.logoid);
				dalNum++;
			});
			
		}
	});
}


function selectAllBrand(v,brand){
	$.ajax({
		url:"order_selectAllBrand.action",
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value='' >-请选择-</option>";
			$(result).each(function(){
				if (this.brId==brand) {
					str+="<option value='"+this.brId+"' selected >"+this.brName+"</option>";
				} else {
					str+="<option value='"+this.brId+"' >"+this.brName+"</option>";
				}
			});
			$(".brand:eq("+v+")").html(str);
			selectAllWarestype(v);
		}
	});
}
function selectAllWarestype(v){
	var brId=$(".brand:eq("+v+")").val();
	$.ajax({
		url:"order_selectAllWarestype.action",
		data:{"brId":brId},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value='' >-请选择-</option>";
			$(result).each(function(){
				if (this.waId==a) {
					str+="<option value='"+this.waId+"' selected >"+this.waName+"</option>";
				} else {
					str+="<option value='"+this.waId+"' >"+this.waName+"</option>";
				}
			});
			$(".warestype:eq("+v+")").html(str);
			selectAllWares(v);
		}
	});
}
function selectAllWares(v){
	var waId=$(".warestype:eq("+v+")").val();
	$.ajax({
		url:"order_selectAllWares.action",
		data:{"waId":waId},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value='' >-请选择-</option>";
			$(result).each(function(){
				if (this.waId==b) {
					str+="<option value='"+this.waId+"' selected >"+this.waName+"</option>";
				} else {
					str+="<option value='"+this.waId+"' >"+this.waName+"</option>";
				}
			});
			$(".wares:eq("+v+")").html(str);
			selectAllFirm(v);
		}
	});
}
function selectAllFirm(v){
	var waId=$(".wares:eq("+v+")").val();
	$.ajax({
		url:"order_selectAllFirm.action",
		data:{"waId":waId},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value='' >-请选择-</option>";
			$(result).each(function(){
				if (this.fiId==c) {
					str+="<option value='"+this.fiId+"' selected >"+this.fiName+"</option>";
				} else {
					str+="<option value='"+this.fiId+"' >"+this.fiName+"</option>";
				}
				
			});
			$(".firm:eq("+v+")").html(str);
		}
	});
}



function selectAllClient(f_id){
	$.ajax({
		url:"order_selectAllClient.action",
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var str="<option value='' >-请选择-</option>";
			$(result).each(function(){
				if (this.f_id==f_id) {
					str+="<option value='"+this.f_id+"' selected >"+this.f_name+"</option>";
				}else {
					str+="<option value='"+this.f_id+"' >"+this.f_name+"</option>";
				}
			});
			$("#client").html(str);
		}
	});
}
var vv=0;
function autoSum(v) {
	vv=v;
	var count=$(".count:eq("+v+")").val();
	var auditor=$(".auditor:eq("+v+")").val();
	if (count<0) {
		$(".count:eq("+v+")").focus();
	}else if(auditor<0){
		$(".auditor:eq("+v+")").focus();
	}else {
		if (count!=null&&auditor!=null) {
			var SumMoney=count*auditor;
			$(".SumMoney:eq("+v+")").val(SumMoney);
			var sum=0;
			$(".SumMoney").each(function(){
				var c=$(this).val();
				sum+=Number(c);
			});
			$("#f_Moneysum").val(sum);
		}
	}
}
function autoNumYan() {
	var v=vv;
	var count=$(".count:eq("+v+")").val();
	var auditor=$(".auditor:eq("+v+")").val();
	var i=0;
	if (count<0) {
		$(".count:eq("+v+")").focus();
		i++;
	}else if(auditor<0){
		$(".auditor:eq("+v+")").focus();
		i++;
	}
	if (i!=0) {
		return false;
	} else {
		return true;
	}
}

function updateProductdetail() {
	if (toYanFirm()&&autoNumYan()) {
		var data = $("#data").serialize();
		$.ajax({
			url:"order_updateProductdetail.action",
			data:data,
			dataType:"json",
			async:false,
			type:"post",
			success:function(result){
				if(result==true){
					window.location.href="orderList.html";
				}else{
					alert("修改失败！");
				}
				
			}
		});
	}
}

function toYan(v) {
	var waresid=$(".wares:eq("+v+")").val();
	var firmid=$(".firm:eq("+v+")").val();
	for (var i = 0; i < v; i++) {
		var waresid1=$(".wares:eq("+i+")").val();
		var firmid1=$(".firm:eq("+i+")").val();
		if (waresid1==waresid && firmid1==firmid) {
			$(".tablelist tbody tr:eq("+v+")").last().remove();
			dalNum--;
			alert("上面有相同厂商的产品,前往修改数据即可");
			$(".count:eq("+i+")").focus();
		}
	}
	
}

function toYanFirm() {
	var i=0;
	$(".firm").each(function() {
		var firmid=$(this).val();
		if (firmid==null||firmid=="") {
			$(this).focus();
			i++;
		}
	});
	if (i!=0) {
		return false;
	} else {
		return true;
	}
}


function timeToDate() {
    var d = new Date();//时间戳记得乘以1000再进行处理
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
    var timeToDate=year + "-" + month + "-" + date+" "+huor+":"+minute+":"+second;
    return timeToDate;
}
function toDid() {
	var d = new Date();//时间戳记得乘以1000再进行处理
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
	return "DJ"+year + "" + month + "" + date+""+huor+""+minute+""+second;
}
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
