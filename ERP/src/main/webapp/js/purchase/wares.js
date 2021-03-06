
var pageInfo;//定义全局变量接收分页信息;

/**
 * 查询所有的品牌
 * @returns
 */
function queryAllBrands(){
	$.ajax({
		url:"queryAllBrands.action",
		dataType:"json",
		type:"post",
		async:false,
		success:function(result){
			var options="";
			options="<option value=''>请选择</option>";
			$(result).each(function(i){
				options+="<option value="+this.brId+">"+this.brName+"</option>";
			})
			$("select[name=waBrandid]").html(options);
		}
	})
}
/**
 * 查询品牌类型
 * @returns
 */
function queryWarestypeByBrId(){
	var brandid = $("select[name=waBrandid]").val();
	$.ajax({
		url:"queryWarestypeByBrId.action",
		data:{"brandid":brandid},
		dataType:"json",
		type:"post",
		async:false,
		success:function(result){
			var options="";
			options="<option value=''>请选择</option>";
			$(result).each(function(i){
				options+="<option value="+this.waId+">"+this.waName+"</option>";
			})
			$("select[name=waWarestypeid]").html(options);
		}
	})
}

/**
 * 分页查询商品
 * @returns
 */
function queryWaresByPage(){
	var data=$("#queryForm").serialize();
	$.ajax({
		url:"queryWaresByPage.action",
		data:data,
		dataType:"json",
		type:"post",
		async:false,
		success:function(result){
			pageInfo=result;
			var trs="";
			$(result.list).each(function(i){
				trs+="<tr>"
				trs+="<td>"+(i+1)+"</td>";
		        trs+="<td>"+this.brName+"</td>";
		        trs+="<td>"+this.warestypeName+"</td>";
		        trs+="<td>"+this.waName+"</td>";
		        trs+="<td>"+this.waUnit+"</td>";
		        trs+="<td>"+(this.waStatus==0?"不可用":"可用")+"</td>";
		        trs+="<td>"+this.time+"</td>"
		        trs+="<td>"+this.empName+"</td>"
		        trs+="<td>";
		        trs+="<a href='productUpdate.html?waId="+this.waId+"' class='tablelink'>修改</a>    " ;
		        	if(this.waStatus==1){
		        		trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('是否确认注销此条信息？',waId="+this.waId+",ff=0)>注销</a>";
		        	}else{
		        		trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('是否确认恢复此条信息？',waId="+this.waId+",ff=1)>恢复</a>";
		        	}
		        trs+="</td>"
		        trs+="</tr>" 
			})
			$("tbody").html(trs);
			$("div i:eq(0)").text(result.total);
 			$("div i:eq(1)").text(result.pageNum);
 			$("div i:eq(2)").text(result.pages);
 			$("input[name=pageNum]").val(result.pageNum);
 			var lis="";
 				lis+="<li class='paginItem'><a href='javascript:toPage(1);'><span class='pagepre'></span></a></li>";
	 	        	if((result.pageNum-2)>0){
	 	        		lis+="<li class='paginItem'><a href='javascript:toPageByValue("+(result.pageNum-2)+");'>"+(result.pageNum-2)+"</a>"+"</li>";
	 	        	} 
	 	        	if((result.pageNum-1)>0){
	 	        		lis+="<li class='paginItem'><a href='javascript:toPageByValue("+(result.pageNum-1)+");'>"+(result.pageNum-1)+"</a>"+"</li>";
	 	        	}
	 	        lis+="<li class='paginItem current'><a href='javascript:toPageByValue("+(result.pageNum)+");'>"+result.pageNum+"</a>"+"</li>";
	 	        	if((result.pageNum+1)<=result.pages){
	 	        		lis+="<li class='paginItem'><a href='javascript:toPageByValue("+(result.pageNum+1)+");'>"+(result.pageNum+1)+"</a>"+"</li>" ;
	 	        	}
	 	        	if((result.pageNum+2)<=result.pages){
	 	        		lis+="<li class='paginItem'><a href='javascript:toPageByValue("+(result.pageNum+2)+");'>"+(result.pageNum+2)+"</a>"+"</li>";
	 	        	}
	 	        lis+="<li class='paginItem'><a href='javascript:toPage(2);'><span class='pagenxt'></span></a></li>";
 			$(".paginList").html(lis);
		}
	});
}
function query(){
	$("input[name=pageNum]").val(1)
	queryWaresByPage();
} 

function toPage(value){
	if(value==1){
		if(pageInfo.pageNum>1){
			$("input[name=pageNum]").val(pageInfo.pageNum-1)
			queryWaresByPage()
		}else{
			alert("已经是第一页了")
		}
	}else if(value==2){
		if(pageInfo.pageNum<pageInfo.pages){
			$("input[name=pageNum]").val(pageInfo.pageNum+1)
			queryWaresByPage()
		}else{
			alert("已经是最后一页了")
		}
	}
}

function toPageByValue(value){
	$("input[name=pageNum]").val(value);
	queryWaresByPage();
}


function queryWaresById(){
	var waId =getUrlParam("waId")
	$.ajax({
		url:"queryWaresById.action",
		data:{"waId":waId},
		dataType:"json",
		type:"post",
		success:function(result){
			$("select:eq(0) option").each(function(i){
				if($(this).val()==result.waBrandid){
					$(this).prop("selected",true);
				}
			});
			$(".dfinput:eq(0)").val(result.waName);
			$(".dfinput:eq(1)").val(result.waUnit);
			
			queryWarestypeByBrId();
			
			$("select:eq(1) option").each(function(i){
				if($(this).val()==result.waWarestypeid){
					$(this).prop("selected",true);
				}
			});
			$("select:eq(2) option").each(function(i){
				if($(this).val()==result.waStatus){
					$(this).prop("selected",true);
				}
			});
			$("input[name=waId]").val(result.waId);
			$("#empName").val(result.empName);
			$("#waCreatetime").val(result.time);
			
		}
	})
}

function updateWares(){
	var data=$("#updateForm").serialize();
	$.ajax({
		url:"updateWares.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.flag=="true"){
				window.location.href="productList.html";
			}else{
				alert("修改失败，请重试")
			}
		}
	});
}
function cancelWares(waId){
	$.ajax({
		url:"cancelWares.action",
		data:{"waId":waId},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.flag=="true"){
				window.location.href="productList.html";
			}else{
				alert("修改失败，请重试")
			}
		}
	});
}
function recoverWares(waId){
	$.ajax({
		url:"recoverWares.action",
		data:{"waId":waId},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.flag=="true"){
				window.location.href="productList.html";
			}else{
				alert("修改失败，请重试")
			}
		}
	});
}
function addWares(){
	if($("select[name=waBrandid]").val()!=''&&$("select[name=waWarestypeid]").val()!=''
		&&$("select[name=waStatus]").val()!=''&&$("input[name=waUnit]").val()!=''
			&&$("input[name=waName]").val()!=''){
		var data=$("#addForm").serialize();
		$.ajax({
			url:"addWares.action",
			data:data,
			dataType:"json",
			type:"post",
			success:function(result){
				if(result.flag=="true"){
					window.location.href="productList.html";
				}else{
					alert("修改失败，请重试")
				}
			}
		});
	}else{
		alert("数据有误请重新输入");
	}
}

function loginUser(){
	$.ajax({
		url:"loginUser.action",
		dataType:"json",
		type:"post",
		success:function(result){
			$("input[name=empName]").val(result.f_name)
		}
	});
}


//将毫秒值转换成年月日   时分秒格式  
function getMyDate(str){  
	var oDate = new Date(str),  
	oYear = oDate.getFullYear(),  
	oMonth = oDate.getMonth()+1,  
	oDay = oDate.getDate(),  
	oHour = oDate.getHours(),  
	oMin = oDate.getMinutes(),  
	oSen = oDate.getSeconds(),  
	oTime = oYear +'-'+ addZero(oMonth) +'-'+ addZero(oDay) +' '+ addZero(oHour) +':'+ addZero(oMin) +':'+addZero(oSen);//最后拼接时间  
	return oTime;  
};  
//补0操作  
function addZero(num){  
	if(parseInt(num) < 10){  
		num = '0'+num;  
	}  
	return num;  
}

