/**
 * 日志管理
 */
var page;
function toPage(pageNow){
	$("input[name='pageNum']").val(pageNow);
	queryLog();
}
function queryLog(){  
	var data = $("#selectForm").serialize();
	$.ajax({
	    url:"log.action",
	    data:data,
		async:true,
		dataType:"json",
		type:"post",
	    success:function(result){
	    	page=result;
	    	var i=1;
			  var trs = "";
			  $(result.list).each(function(){
				  trs+="<tr>";
				  trs+="<td>"+this.f_id+"</td>";
				  trs+="<td>"+this.f_userId+"</td>";
				  trs+="<td>"+this.f_userName+"</td>";
				  trs+="<td>"+this.f_module+"</td>";
				  trs+="<td>"+this.f_context+"</td>";
				  trs+="<td>"+this.f_time+"</td>";
				  trs+="<td>";
				  trs+="<a href='logView.html?f_id="+this.f_id+"' class='tablelink'>查看详情 </a>";
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
 * 传值
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
/**
 * 查看详情
 * @returns
 */
function queryLogView() {
	var data=getUrlParam("f_id");
	$.ajax({
		url:"logView.action",
		data:{"f_id":data},
		dataType:"json",
		async:false,
		type:"post",
		success:function(result){
			$("cite:eq(0)").html(result.f_userId);
			$("cite:eq(1)").html(result.f_userName);
			$("cite:eq(2)").html(result.f_module);
			$("cite:eq(3)").html(result.f_context);
			$("cite:eq(4)").html(result.f_time);
		}
	});
}