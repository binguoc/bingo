/**
 * 厂商采购统计
 */
var page;
function toPage(pageNow){
	$("input[name='pageNum']").val(pageNow);
	queryPurchase();
}
function queryPurchase(){  
	var data = $("#selectForm").serialize();
	$.ajax({
	    url:"purchaseStatis.action",
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
				  trs+="<td>"+i+"</td>";
				  trs+="<td>"+this.f_csName+"</td>";
				  trs+="<td>"+this.f_fzName+"</td>";
				  trs+="<td>"+this.pro_name+""+this.city_name+"</td>";
				  trs+="<td>"+this.f_count+"</td>";
				  trs+="<td>"+this.f_money+"</td>";
				  trs+="<td>";
				  trs+="<a href='purchaseView.html?f_csName="+this.f_csName+"' class='tablelink'>查看详情 </a>";
				  trs+="</td>";
				  trs+="</tr>"; 
				  i++;
			  });
			  $("#tbody").html(trs);
			  $('.tablelist tbody tr:odd').addClass('odd');
		      pageButton();
		}
	});
}