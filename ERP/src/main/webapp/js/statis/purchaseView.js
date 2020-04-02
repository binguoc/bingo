/**
 * 厂商采购详情
 */
var page;
function toPage(pageNow){
	$("input[name='pageNum']").val(pageNow);
	queryPurchaseView();
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
/**
 * 厂商采购查询
 * @returns
 */
function queryPurchaseView(){  
	var data=getUrlParam("f_csName");
	$.ajax({
	    url:"purchaseView.action",
	    data:{"f_csName":data},
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
				trs+="<td>"+this.f_csName+"</td>";
				trs+="<td>"+this.f_ddId+"</td>";
				trs+="<td>"+this.f_count+"</td>";
				trs+="<td>"+this.f_money+"</td>";
				trs+="<td>"+timeToDate(this.f_time)+"</td>";
				trs+="<td>"+this.f_czName+"</td>";
			    trs+="<td>";
				trs+="<a href='../../purchase/purchase/purchaseView.html?puRealid="+this.f_ddId+"' class='tablelink'>查看详情 </a>";
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