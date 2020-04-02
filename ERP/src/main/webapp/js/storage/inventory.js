var page;
var user;
function toPage(value){
	$("input[name=pageNum]").val(value);//每次点击查询按钮，当前页初始化为1
	queryAllInventory();//按条件分页查询，显示数据
}
/**
 * 查询所有的库存
 * @returns
 */
function queryAllInventory(){
	queryUser();
	if(!(user.f_positionid.f_id==7 ||user.f_positionid.f_id==4)){
		$("#stCreateMan").val(user.f_name);
	}
	var data = $("#selectForm").serialize();
	$.ajax({
		url:"queryAllInventory.action",
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
				trs+="<td>"+this.storage.stName+"</td>";
				trs+="<td>"+this.wares.brName+"</td>";
				trs+="<td>"+this.wares.warestypeName+"</td>";
				trs+="<td>"+this.wares.waName+"</td>";
				trs+="<td>"+this.firm.fiName+"</td>";
				trs+="<td>"+this.inNum+"</td>";
				trs+="<td>"+this.wares.waUnit+"</td>";
				trs+="</tr>";
				i++;
	    	});
			$("tbody").html(trs);
			$('.tablelist tbody tr:odd').addClass('odd');
			pageButton();
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