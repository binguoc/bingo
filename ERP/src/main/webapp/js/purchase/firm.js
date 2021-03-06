
var pageInfo;//定义全局变量接收分页信息;

/**
 * 查询所有的省
 * @returns
 */
function queryAllProvince(){
	$.ajax({
		url:"queryAllProvince.action",
		dataType:"json",
		type:"post",
		async:false,
		success:function(result){
			var options="";
			options="<option value=''>请选择省份</option>";
			$(result).each(function(i){
				options+="<option value="+this.pro_id+">"+this.pro_name+"</option>";
			})
			$("select[name=fiAddressProvince]").html(options);
		}
	})
}
/**
 * 查询市
 * @returns
 */
function queryAllCityByProId(){
	var pro_id = $("select[name=fiAddressProvince]").val();
	$.ajax({
		url:"queryAllCityByProId.action",
		data:{"pro_id":pro_id},
		dataType:"json",
		type:"post",
		async:false,
		success:function(result){
			var options="";
			options="<option value=''>请选择城市</option>";
			$(result).each(function(i){
				options+="<option value="+this.city_id+">"+this.city_name+"</option>";
			})
			$("select[name=fiAddressCity]").html(options);
		}
	})
}

/**
 * 分页查询厂商
 * @returns
 */
function queryAllFirmByPage(){
	var data=$("#queryForm").serialize();
	$.ajax({
		url:"queryAllFirmByPage.action",
		data:data,
		dataType:"json",
		type:"post",
//		async:false,
		success:function(result){
			pageInfo=result;
			var trs="";
			$(result.list).each(function(i){
				trs+="<tr>"
				trs+="<td>"+(i+1)+"</td>";
		        trs+="<td>"+this.fiName+"</td>";
		        trs+="<td>"+this.fiDirectorUserName+"</td>";
		        trs+="<td>"+this.fiPhone+"</td>";
		        trs+="<td>"+this.fiProvinceCity+"</td>";
		        trs+="<td>"+(this.fiStatus==0?"不可用":"可用")+"</td>";
		        trs+="<td>"+this.time+"</td>"
		        trs+="<td>"+this.fiCreateUserName+"</td>"
		        trs+="<td>";
		        trs+="<a href='manufacturerView.html?fiId="+this.fiId+"' class='tablelink'>查看详情</a> ";
		        	if(this.fiStatus==1){
		        		trs+="<a href='manufacturerUpdate.html?fiId="+this.fiId+"' class='tablelink'>修改</a> "
		        		trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('是否确认注销此条信息？',"+this.fiId+",ff=0)>注销</a>";
		        	}else{
		        		trs+="<a href='javascript:void(0)' class='tablelink' onclick=tipOpen('是否确认恢复此条信息？',"+this.fiId+",ff=1)>恢复</a>";
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
	queryAllFirmByPage();
} 

function toPage(value){
	if(value==1){
		if(pageInfo.pageNum>1){
			$("input[name=pageNum]").val(pageInfo.pageNum-1)
			queryAllFirmByPage()
		}else{
			alert("已经是第一页了")
		}
	}else if(value==2){
		if(pageInfo.pageNum<pageInfo.pages){
			$("input[name=pageNum]").val(pageInfo.pageNum+1)
			queryAllFirmByPage()
		}else{
			alert("已经是最后一页了")
		}
	}
}

function toPageByValue(value){
	$("input[name=pageNum]").val(value);
	queryAllFirmByPage();
}


function queryFirmByIdView(){
	var fiId =getUrlParam("fiId")
	$.ajax({
		url:"queryFirmById.action",
		data:{"fiId":fiId},
		dataType:"json",
		type:"post",
		success:function(result){
			$("cite:eq(0)").html(result.fiName);
			$("cite:eq(1)").html(result.fiDirectorUserName);
			$("cite:eq(2)").html(result.fiPhone);
			$("cite:eq(3)").html(result.fiRealAddress);
			$("cite:eq(4)").html(result.fiProvinceCity);
			$("cite:eq(5)").html(result.fiDescribe);
			$("cite:eq(6)").html(result.fiStatus==0?"不可用":"可用");
			$("cite:eq(7)").html(result.fiCreateUserName);
			$("cite:eq(8)").html(result.time);
		}
	});
}
function queryFirmByIdUpdate(){
	var fiId =getUrlParam("fiId")
	$.ajax({
		url:"queryFirmById.action",
		data:{"fiId":fiId},
		dataType:"json",
		type:"post",
		async:false,
		success:function(result){
			$("input[name=fiId]").val(result.fiId);
			$("input[name=fiName]").val(result.fiName);
			$("input[name=fiDirectorUserName]").val(result.fiDirectorUserName);
			$("input[name=fiPhone]").val(result.fiPhone);
			$("input[name=fiRealAddress]").val(result.fiRealAddress);
			$("input[name=fiProvinceCity]").val(result.fiProvinceCity);
			$("textarea[name=fiDescribe]").val(result.fiDescribe);
			
			$("select:eq(0) option").each(function(i){
				if($(this).val()==result.fiAddressProvince){
					$(this).prop("selected",true);
				}
			});
			queryAllCityByProId();
			$("select:eq(1) option").each(function(i){
				if($(this).val()==result.fiAddressCity){
					$(this).prop("selected",true);
				}
			});
			$("select:eq(2) option").each(function(i){
				if($(this).val()==result.fiStatus){
					$(this).prop("selected",true);
				}
			});
			
			$("input[id=fiCreateUserName]").val(result.fiCreateUserName);
			$("input[id=fiCreatetime]").val(result.time);
			
		}
	});
}

function updateFirm(){
	var data=$("#updateForm").serialize();
	$.ajax({
		url:"updateFirm.action",
		data:data,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.flag=="true"){
				window.location.href="manufacturerList.html";
			}else{
				alert("修改失败，请重试")
			}
		}
	});
}
function cancelFirm(fiId){
	$.ajax({
		url:"cancelFirm.action",
		data:{"fiId":fiId},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.flag=="true"){
				window.location.href="manufacturerList.html";
			}else{
				alert("修改失败，请重试")
			}
		}
	});
}
function recoverFirm(fiId){
	$.ajax({
		url:"recoverFirm.action",
		data:{"fiId":fiId},
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.flag=="true"){
				window.location.href="manufacturerList.html";
			}else{
				alert("修改失败，请重试")
			}
		}
	});
}
function addFirm(){
	if($("input[name=fiName]").val()!=''&&$("input[name=fiDirectorUserName]").val()!=''
		&&$("input[name=fiPhone]").val()!=''&&$("input[name=fiRealAddress]").val()!=''
			&&$("select[name=fiAddressProvince]").val()!=''
				&&$("select[name=fiAddressCity]").val()!=''
					&&$("select[name=fiStatus]").val()!=''){
		var data=$("#addForm").serialize();
		$.ajax({
			url:"addFirm.action",
			data:data,
			dataType:"json",
			type:"post",
			success:function(result){
				if(result.flag=="true"){
					window.location.href="manufacturerList.html";
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
			$("input[name=fiCreateUserName]").val(result.f_name)
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

