/**
 * city
 */
var page;
function toPage(pageNow){
	$("input[name='pageNum']").val(pageNow);
	selectcity();
}
function selectcity(){
	var data = $("#selectForm").serialize();
    	  $.ajax({
    		  url:"city.action",
    		  data:data,
    		  async:false,
    		  dataType:"json",
    		  type:"post",
    		  success:function(result){
    			  page=result;
    			  var trs = "";
    			  var i=1;
    			  $(result.list).each(function(){
    				  trs+="<tr>";
    				  trs+="<td>"+i+"</td>";
    				  trs+="<td>"+this.province.pro_id+"</td>";
    				  trs+="<td>"+this.province.pro_name+"</td>";
    				  trs+="<td>"+this.city_id+"</td>";
    				  trs+="<td>"+this.city_name+"</td>";
    				  trs+="</tr>"; 
    				  i++;
    			  });
    			  $("tbody").html(trs);
    			  $('.tablelist tbody tr:odd').addClass('odd');
    		      pageButton();
    		  }
    	  });
      }