var page;
var user;
function toPage(value){
	$("input[name=pageNum]").val(value);//每次点击查询按钮，当前页初始化为1
	queryAllDelivery();//按条件分页查询，显示数据
}
function timeToDate(data) {
    var d = new Date(data);//时间戳记得乘以1000再进行处理
    var year = d.getFullYear();
    var month = d.getMonth()+1;
    var date = d.getDate();
    var hour = d.getHours();
    var minute = d.getMinutes();
    var second = d.getSeconds();
    return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}



function tipOpen(content,deId,deStatic,flags) {
	
	$(".sure").attr("onclick","updateDeliveryDeStatic('"+deId+"','"+deStatic+"','"+flags+"')");
	$(".tipright p").text(content);
	$("#tip").fadeIn(200);
}
function tipClose() {
	$("#tip").fadeOut(200);
}

function today(){//构建方法
    var d=new Date();//new 出当前时间
    var year = d.getFullYear();
    var month = d.getMonth()+1;
    var date = d.getDate();
    var hour = d.getHours();
    var minute = d.getMinutes();
    var second = d.getSeconds();
    return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
} 

/**
 * 获取地址栏传值
 * @param name
 * @returns
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

/**
 * 查询所有的出库表
 * @returns
 */
function queryAllDelivery(){
	queryUser();
	if(!(user.f_positionid.f_id==7 ||user.f_positionid.f_id==4)){
		$("#stCreateMan").val(user.f_name);
	}
	var data = $("#selectForm").serialize();
	$.ajax({
		url:"queryAllDelivery.action",
		data:data,
		async:false,
		dataType:"json",
		type:"post",
		success:function(result){
			page=result;
			var i=1;
			var trs = "";
			$(result.list).each(function(){
					trs+="<tr>";
					trs+="<td>"+i+"</td>";
					trs+="<td>"+this.order.f_did+"</td>";
					trs+="<td>"+format(this.order.f_Moneysum)+"</td>";
					trs+="<td>"+this.storage.stName+"</td>";
					trs+="<td>"+timeToDate(this.storage.stTime)+"</td>";
					trs+="<td>"+this.deMan+"</td>";
					if(this.deStatic==0){trs+="<td>未发货</td>";}
					if(this.deStatic==1){trs+="<td>已发货</td>";}
					if(this.deStatic==2){trs+="<td>已回款</td>";}
					if(this.deStatic==3){trs+="<td>取消订单</td>";}
					if(this.deStatic==4){trs+="<td>已退货</td>";}
					trs+="<td>";
					if (!(user.f_positionid.f_id==7 ||user.f_positionid.f_id==4) ) {
						if(this.deStatic==0){
							trs+="<a href='deliveryView.html?id="+this.order.f_did+"' class='tablelink'>查看详情 </a>"; 
							trs+="<a href='javascript:void(0)' class='tablelink' class='tablelink' onclick=tipOpen('确定此订单发货吗？','"+this.deId+"','0','发货')>发货 </a>"; 
							trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('确定取消此订单吗？','"+this.deId+"','0','取消订单')>取消订单 </a>"; 
						}
						if(this.deStatic==1){
				            trs+="<a href='deliveryView.html?id="+this.order.f_did+"' class='tablelink'>查看详情 </a>"; 
				            trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('确定取消此订单吗？','"+this.deId+"','1','取消订单')>取消订单 </a>"; 
							trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('确定收到此订单回款吗？','"+this.deId+"','1','确认回款')>确认回款 </a>"; 
							
						}
						if(this.deStatic==2){
							trs+="<a href='deliveryView.html?id="+this.order.f_did+"' class='tablelink'>查看详情 </a>"; 
							trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('确定取消此订单吗？','"+this.deId+"','2','取消订单')>取消订单 </a>"; 
						}
						if(this.deStatic==3){
							trs+="<a href='deliveryView.html?id="+this.order.f_did+"' class='tablelink'>查看详情 </a>"; 
							trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('确定收到此订单的退货吗？','"+this.deId+"','3','确认已退货')>确认已退货 </a>"; 
						}
						if(this.deStatic==4){
							trs+="<a href='deliveryView.html?id="+this.order.f_did+"' class='tablelink'>查看详情 </a>"; 
						}
					}else{
						$("#add1").remove();
						trs+="<a href='deliveryView.html?id="+this.order.f_did+"' class='tablelink'>查看详情 </a>"; 
					}
					trs+="</td>";
					trs+="</tr>";
				i++;
	    	});
			$("tbody").html(trs);
			$('.tablelist tbody tr:odd').addClass('odd');
			pageButton();
		}
	});
}





/**
 *操作修改状态方法
 * @param deId
 * @param deStatic
 * @returns
 */
function updateDeliveryDeStatic(deId,deStatic,deMan){
	$.ajax({
		url:"updateDeliveryDeStatic.action",
		data:{"deId":deId,"deStatic":deStatic,"deMan":deMan},
		dataType:"json",
		type:"post",
		success:function(result){
			if(deStatic==0  & deMan=="发货"){
				if(result==false){
					alert("库存不足");
				}else{
					alert("发货成功");
				}
			}
			if((deStatic==0  & deMan=="取消订单") |(deStatic==1  & deMan=="取消订单")|(deStatic==2  & deMan=="取消订单")){
				if(result==false){
					alert("取消订单失败");
				}else{
					alert("取消订单成功");
				}
			}
			if(deStatic==1 & deMan=="确认回款" ){
				if(result==false){
					alert("回款失败");
				}else{
					alert("回款成功");
				}
			}
			
			if(deStatic==3 & deMan=="确认已退货"){
				if(result==false){
					alert("退货失败");
				}else{
					alert("退货成功");
				}
			}
			tipClose();
			window.location.href="deliveryList.html";
	    }	
	});
}


/**
 * 查询通过审核的订单
 * @returns
 */
function queryOrderIDStatic(){
	$.ajax({
		url:"queryOrderIDStatic.action",
		async:false,
		dataType:"json",
		type:"post",
		success:function(result){
			page=result;
			var options = "";
			$(result).each(function(){
				options += "<option value='"+this.f_id+"'>"+this.f_did +"</option>";
			});
			$("#f_did").html(options);
			toOrder();
		}
	});
}

function toOrder() {
	var f_did=$("#f_did").find("option:selected").text();
	var toorder="<a href='../../market/order/orderView.html?id="+f_did+"' title='点击查看客户详细信息' class='tablelink'>详情</a>";
	$(".forminfo li i:eq(0)").html(toorder);
	
}

//查询所有的仓库
function queryAllStorage(){
	var data = $("#addStCreateMan").serialize();
	$.ajax({
		url:"queryAllStorage.action",
		data:data,
		async:false,
		dataType:"json",
		type:"post",
		success:function(result){
			page=result;
			var options = "";
			$(result).each(function(){
				options += "<option value="+this.stId+">"+this.stName +"</option>";
			}); 
			$("#stName").html(options);
		}
	});
}
/**
 * 出库表添加功能
 * @returns
 */
function addDelivery(){
	var data = $("#addForm").serialize();
	$.ajax({
		url:"addDelivery.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result==0){
				alert("添加失败");
				window.location.href="deliveryAdd.html";
			}else{
				alert("添加成功");
				window.location.href="deliveryList.html";
			}
	    }	
	
	});
}


/**
 * 查看详情+出库信息
 * @returns
 */
function queryByDid(){
	$.ajax({
		url:"queryByDid.action",
		data:{"f_did":getUrlParam("id")},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			var t="<a href='../storage/storageView.html?stId="+(result[0].storage==null?'':result[0].storage.stId)+"' title='点击查看客户详细信息' class='tablelink'>"+(result[0].storage==null?'':result[0].storage.stName)+"</a>";
			$("cite:eq(10)").html(t);
			$("cite:eq(11)").html(today(result[0].deTime));
			$("cite:eq(12)").html(result[0].deMan);
			$("cite:eq(13)").html((result[0].deStatic==0?"未发货":result[0].deStatic==1?"已发货":result[0].deStatic==2?"已回款":result[0].deStatic==3?"取消订单":"已退货"));
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
			user=result;
			$("#stoMan").val(result.f_name);
		}
	});
}

