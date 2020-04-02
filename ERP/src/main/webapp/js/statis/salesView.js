/**
 * 销量详情
 */
var page;
function toPage(pageNow){
	$("input[name='pageNum']").val(pageNow);
	querySalesView();
}
/**
 * 获取地址栏传值
 * @param name
 * @returns
 */

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return decodeURI(r[2]); return null; //返回参数值
}

function querySalesView(){  
	var data=getUrlParam("f_name");
	$.ajax({
	    url:"salesView.action",
	    data:{"f_name":data},
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
				trs+="<td>"+this.f_name+"</td>";
				trs+="<td>"+this.f_did+"</td>";
				trs+="<td>"+this.f_count+"</td>";
				trs+="<td>"+this.f_money+"</td>";
				trs+="<td>"+this.f_time+"</td>";
				trs+="<td>"+this.f_auditor+"</td>";
			    trs+="<td>";
				trs+="<a href='../../market/order/orderView.html?id="+this.f_did+"' class='tablelink'>查看详情 </a>";
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