/**
 * 省市二级联动
 */
function selectProvince(){
	  $.ajax({
		  url:"statisProvince.action",
		  async:true,
		  dataType:"json",
		  type:"post",
		  success:function(result){
			  var str="<option value='-1'>请选择省份</option>";
			  $(result).each(function(){
				  str+="<option value='"+this.pro_id+"'>"+this.pro_name+"</option>";
			  });
		      $("#Province").html(str);
		  }
	  });
}

function selectCity(){
	var pro_id=$("#Province").val()
	$.ajax({
		  url:"statisCity.action",
		  data:{"pro_id":pro_id},
		  dataType:"json",
		  type:"post",
		  success:function(result){
			  var str="<option value='-1'>请选择城市</option>";
			  $(result).each(function(){
				  str+="<option value='"+this.city_name+"'>"+this.city_name+"</option>";
			  });
		      $("#City").html(str);
		  }
	  });
}